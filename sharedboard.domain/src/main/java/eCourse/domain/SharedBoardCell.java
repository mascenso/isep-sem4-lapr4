package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class SharedBoardCell implements AggregateRoot<String> {

    private enum CellState {
        EMPTY, FILLED
    }

    @Id
    private String id; //custom SBtitle_1,2

    @Enumerated(EnumType.STRING)
    private CellState state;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sharedboard_title")
    private SharedBoard sharedboard;

    protected SharedBoardCell(SharedBoard matrix, String id) {
        this.sharedboard = matrix;
        this.state = CellState.EMPTY;
        this.id = matrix.boardTitle().toString() + "_" + id;
    }

    public SharedBoardCell() {
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return id;
    }
}
