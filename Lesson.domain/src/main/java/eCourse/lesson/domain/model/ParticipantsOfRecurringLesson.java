package eCourse.lesson.domain.model;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;

@Entity
public class ParticipantsOfRecurringLesson implements AggregateRoot<Username> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecurringLesson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParticipant;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private RecurringLesson recurringLesson;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private SystemUser participant;

    public ParticipantsOfRecurringLesson(RecurringLesson recurringLesson, SystemUser participant) {
        this.recurringLesson = recurringLesson;
        this.participant = participant;
    }

    public ParticipantsOfRecurringLesson() {

    }

    public SystemUser participant(){
        return this.participant;
    }

    public RecurringLesson recurringLesson() {
        return this.recurringLesson;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Username identity() {
        return this.participant.identity();
    }
}
