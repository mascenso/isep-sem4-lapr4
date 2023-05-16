package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

@Entity
public class ParticipantsOfMeeting implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipant;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private SystemUser participant;

    public ParticipantsOfMeeting(Meeting meeting, SystemUser participant) {
        this.meeting = meeting;
        this.participant = participant;
    }

    public ParticipantsOfMeeting() {

    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.idParticipant;
    }

}
