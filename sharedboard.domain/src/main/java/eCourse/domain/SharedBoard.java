package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
public class SharedBoard implements AggregateRoot<SharedBoardTitle> {

    @EmbeddedId
    private SharedBoardTitle title;

    @Column
    private int numberRows;
    @Column
    private int numberColumns;

    /*@Embedded
    private SharedBoardColumnAndRow position;*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHARED_BOARD_TITLE")
    private List<Linha> linhas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHARED_BOARD_TITLE")
    private List<Coluna> colunas;

    @ManyToOne
    @JoinColumn()
    private SystemUser owner;

    @Column
    private boolean archive;

    private Map<SystemUser, AccessType> usersWithPermissions;

    public SharedBoard(final SharedBoardTitle title, int numberColumns, int numberRows, boolean archive, final SystemUser owner, List<Coluna> columns, List<Linha> rows) {
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if ((numberColumns < 1) || (numberColumns > 10)) {
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        if ((numberRows < 1) || (numberRows > 20)) {
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.title = title;
        this.numberColumns = numberColumns;
        this.numberRows = numberRows;
        this.owner = owner;
        this.archive = archive;
        this.colunas = columns;
        this.linhas = rows;
    }

    public SharedBoard(int numberRows, int numberColumns) {
        if ((numberColumns < 1) || (numberColumns > 10)) {
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        if ((numberRows < 1) || (numberRows > 20)) {
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.numberRows = numberRows;
        this.numberColumns = numberColumns;
    }

    protected SharedBoard() {

    }


    public SharedBoardTitle title() {
        return title;
    }

    public SystemUser owner() {
        return this.owner;
    }

    public boolean archive() {
        return archive;
    }

    public List<Coluna> colunas() {
        return colunas;
    }

    public void setColunas(List<Coluna> colunas) {
        this.colunas = colunas;
    }

    public List<Linha> linhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
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

    public boolean isArchive() {
        return true;
    }

    public int numberOfColumns() {
        return numberColumns;
    }

    public int numberOfRows() {
        return numberRows;
    }


    public static SharedBoardUser createShareBoardUsers(SystemUser user, SharedBoardTitle boardID, AccessType access) {
            return new SharedBoardUser(user, boardID, access);
    }

    /*public SharedBoardColumnAndRow getPosition() {
        return position;
    }

    public void setPosition(SharedBoardColumnAndRow position) {
        this.position = position;
    }*/

}
