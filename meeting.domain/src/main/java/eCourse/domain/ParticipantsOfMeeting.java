package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;

@Entity
public class ParticipantsOfMeeting implements AggregateRoot<Username> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public SystemUser participant(){
        return this.participant;
    }

    public ParticipantsStatus participantStatus() {
        return this.participantsStatus;
    }

    public Meeting meeting() {
        return this.meeting;
    }
    public void accept() {
        participantsStatus = ParticipantsStatus.ACCEPT;
    }

    public void reject() {
        participantsStatus = ParticipantsStatus.REJECTED;
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
