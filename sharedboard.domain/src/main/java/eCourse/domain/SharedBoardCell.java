package eCourse.domain;

import eCourse.domain.postit.PostIt;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class SharedBoardCell implements AggregateRoot<String> {
    private static final long serialVersionUID = 1L;

    private enum CellState {
        EMPTY, FILLED
    }

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id; //custom SBtitle_1,2

    @Enumerated(EnumType.STRING)
    private CellState state;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sharedboard_title")
    private SharedBoard sharedboard;

    @Embedded
    private PostIt postit;

    protected SharedBoardCell(SharedBoard matrix, String id) {
        this.sharedboard = matrix;
        this.state = CellState.EMPTY;
        this.id = matrix.boardTitle().toString() + "_" + id;
        this.postit = null;
    }

    public SharedBoardCell() {
        // for ORM only
    }

    public void addPostIt(PostIt postIt) {
        if (postIt == null) {
            throw new IllegalArgumentException();
        }
        this.postit = postIt;
        this.state = CellState.FILLED;
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
