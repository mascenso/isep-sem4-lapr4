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
        // for ORM only
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof SharedBoardCell)) {
            return false;
        }

        final SharedBoardCell that = (SharedBoardCell) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && state.equals(that.state);
    }

    @Override
    public String identity() {
        return id;
    }
}
