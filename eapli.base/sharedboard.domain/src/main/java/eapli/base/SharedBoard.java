package eapli.base;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SharedBoard implements AggregateRoot<SharedBoardTitle> {

    @EmbeddedId
    private SharedBoardTitle title;

    @Embedded
    private SharedBoardColumnAndRow position;

   /* @Embeddable
    public class SharedBoardPosition {

        @Column(name = "numberColumns")
        private int column;

        @Column(name = "numberRows")
        private int row;
    }*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHARED_BOARD_TITLE")
    private List<Colunas> colunas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHARED_BOARD_TITLE")
    private List<Linhas> linhas;

    @ManyToOne
    @JoinColumn()
    private SystemUser owner;

    @Column
    private boolean archive;


    public SharedBoard(final SharedBoardTitle title, boolean archive, final SystemUser owner, final SharedBoardColumnAndRow position, List<Colunas> columns, List<Linhas> rows) {
        if (title == null || owner == null || position == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.owner = owner;
        this.archive = archive;
        this.position = position;
        this.colunas = columns;
        this.linhas = rows;
    }

    protected SharedBoard() {

    }

    public SharedBoardTitle getTitle(){
        return title;
    }

    public SystemUser getOwner(){
        return this.owner;
    }

    public boolean getArchive(){
        return archive;
    }

    public List<Colunas> getColunas() {
        return colunas;
    }

    public void setColunas(List<Colunas> colunas) {
        this.colunas = colunas;
    }

    public List<Linhas> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linhas> linhas) {
        this.linhas = linhas;
    }

    public void updateArchive(boolean archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public SharedBoardTitle boardTitle() {
        return identity();
    }

    @Override
    public SharedBoardTitle identity() {
        return this.title;
    }

    public boolean isArchive(){
        return true;
    }

    public SharedBoardColumnAndRow getPosition() {
        return position;
    }

    public void setPosition(SharedBoardColumnAndRow position) {
        this.position = position;
    }
    
    /*public String valueAtPosition( int column, int row){
        if (column >= position.getNumberColumns() && column < position.getNumberColumns() + column && row >= position.getNumberRows() && row < position.getNumberRows() + column){
            String[][] data = new String[column][row];
            return data[column - position.getNumberColumns()][row - position.getNumberRows()];
        } else {
            throw new IllegalArgumentException("Position is out of bounds");
        }
    }
    
    public void showSharedBoard(){
        for (int column = 1; column <= position.getNumberColumns(); column++){
            for (int row = 1; row <= position.getNumberRows(); row++){
                System.out.println();
            }
        }
    }*/
}
