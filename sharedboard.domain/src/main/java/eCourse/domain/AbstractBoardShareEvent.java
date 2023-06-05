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
    private final SharedBoardUser what;

    protected AbstractBoardShareEvent() {
        // for ORM
        what = null;
    }

    protected AbstractBoardShareEvent(final SharedBoardUser what) {
        this.what = what;
    }


    public SharedBoardUser what() {
        return what;
    }
}

