package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;

@Entity
public class ParticipantsOfMeeting implements AggregateRoot<Username> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipant;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private SystemUser participant;

    @Enumerated(EnumType.STRING)
    private ParticipantsStatus participantsStatus;

    public ParticipantsOfMeeting(Meeting meeting, SystemUser participant) {
        this.meeting = meeting;
        this.participant = participant;
        this.participantsStatus = ParticipantsStatus.PENDING;
    }

    public ParticipantsOfMeeting() {

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
