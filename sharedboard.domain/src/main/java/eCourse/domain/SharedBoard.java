package eCourse.domain;

import eCourse.domain.enums.AccessType;
import eCourse.domain.postit.PostIt;
import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Entity
public class SharedBoard implements AggregateRoot<SharedBoardTitle> {

    @EmbeddedId
    @Column(name="title")
    private SharedBoardTitle title;

    @Column
    private int numberRows;
    @Column
    private int numberColumns;

    @OneToMany(mappedBy="sharedboard", cascade = CascadeType.ALL)
    private List<SharedBoardCell> matrixCells = new ArrayList<>();

    @ElementCollection
    private List<SBRow> linhas;

    @ElementCollection
    private List<SBColumn> colunas;

    @ManyToOne
    @JoinColumn()
    private SystemUser owner;

    @Column
    private boolean archive;

    @OneToMany
    private List<SharedBoardUser> usersList = new ArrayList<>();


    public SharedBoard(final SharedBoardTitle title, int numberColumns, int numberRows, boolean archive, final SystemUser owner, List<SBColumn> columns, List<SBRow> rows) {
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if ((numberColumns < 1) || (numberColumns > 10)) {
            throw new IllegalArgumentException("SBColumn value must be between 1 and 10");
        }
        if ((numberRows < 1) || (numberRows > 20)) {
            throw new IllegalArgumentException("SBRow value must be between 1 and 20");
        }
        this.title = title;
        this.numberColumns = numberColumns;
        this.numberRows = numberRows;
        this.owner = owner;
        this.archive = archive;
        this.colunas = columns;
        this.linhas = rows;
        this.matrixCells = newEmptyBoard(numberRows, numberColumns);
    }

    private List<SharedBoardCell> newEmptyBoard(int numberRows, int numberColumns) {
        List<SharedBoardCell> matrixCells = new ArrayList<>();
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                matrixCells.add(new SharedBoardCell(this, "_" + i + "," + j));
            }
        }
        return matrixCells;
    }

    public SharedBoard(int numberRows, int numberColumns) {
        if ((numberColumns < 1) || (numberColumns > 10)) {
            throw new IllegalArgumentException("SBColumn value must be between 1 and 10");
        }
        if ((numberRows < 1) || (numberRows > 20)) {
            throw new IllegalArgumentException("SBRow value must be between 1 and 20");
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

    public List<SBColumn> colunas() {
        return colunas;
    }

    public synchronized void changeColumns(List<SBColumn> colunas) {
        this.colunas = colunas;
    }

    public List<SBRow> linhas() {
        return linhas;
    }

    public synchronized void changeRows(List<SBRow> linhas) {
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

    public int numberOfColumns() {
        return numberColumns;
    }

    public int numberOfRows() {
        return numberRows;
    }

    public synchronized void changeNumberOfRows(int numberRows) {
        this.numberRows = numberRows;
    }

    public synchronized void changeNumberOfColumns(int numberColumns) {
        this.numberColumns = numberColumns;
    }

    public synchronized SharedBoardUser createShareBoardUsers(SystemUser user, SharedBoardTitle boardID, AccessType access) {
        SharedBoardUser boardUser = new SharedBoardUser(user, boardID, access);
        this.usersList.add(boardUser);
        return boardUser;
    }

    public PostIt addPostItToCell(PostIt postIt, int row, int column) {

        this.matrixCells.get(row * this.numberColumns + column).addPostIt(postIt);

        return postIt;
    }

}
