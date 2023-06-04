package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;


@Entity
public class Notification implements AggregateRoot<Long> {

    @Id
    private Long id;

    @ManyToOne
    private BoardShareEvent event;

    protected Notification(){

    }
    protected Notification( BoardShareEvent event){
        this.event=event;
    }

    public Notification getNotification(){
        return this;
    }
    public Long getId() {
        return id;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Notification)) {
            return false;
        }

        final Notification otherNotification = (Notification) other;

        return event.equals(otherNotification.event)
                && id.equals(otherNotification.id);
    }

    @Override
    public Long identity() {
        return id;
    }
}
