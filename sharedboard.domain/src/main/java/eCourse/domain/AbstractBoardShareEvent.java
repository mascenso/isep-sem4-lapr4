package eCourse.domain;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.events.DomainEventBase;

import javax.persistence.*;

@Entity
public class AbstractBoardShareEvent extends DomainEventBase implements DomainEvent {
    @Id
    @GeneratedValue
    private Long pk;

    @ManyToOne
    private SharedBoardUser what;

    @ManyToOne
    private SharedBoard board;

    protected AbstractBoardShareEvent() {
        // for ORM
        what = null;
    }

    protected AbstractBoardShareEvent(final SharedBoardUser what) {
        this.what = what;
    }
    protected AbstractBoardShareEvent(final SharedBoard board) {
        this.board = board;
    }

    public SharedBoard board() {
        return board;
    }
    public SharedBoardUser what() {
        return what;
    }
}

