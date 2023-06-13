package eCourse.domain;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.events.DomainEventBase;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AbstractBoardUpdateEvent extends DomainEventBase implements DomainEvent {
    @Id
    @GeneratedValue
    private Long pk;

    @ManyToOne
    private SharedBoard board;

    protected AbstractBoardUpdateEvent(final SharedBoard board) {
        this.board = board;
    }

    protected AbstractBoardUpdateEvent() {
        board = null;
    }

    public SharedBoard board() {
        return board;
    }
}
