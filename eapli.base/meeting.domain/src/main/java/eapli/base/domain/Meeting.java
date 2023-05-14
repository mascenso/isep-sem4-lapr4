package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Meeting implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeeting;

    @Embedded
    private Designation title;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<ParticipantsOfMeeting> participants;


    //duration on minuts
    private int duration;

    @Column
    //date on format dd/mm/yyyy hh:mm
    private Date schedule;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeetingStatus meetingStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeetingTimeStamp meetingTimeStamp;

    public Meeting(Designation name, Date schedule, List<SystemUser> listOfParticipants,int  duration){
        Preconditions.noneNull(name,schedule,duration);

        this.title = name;
        this.duration = duration;
        this.schedule = schedule;

        this.participants = new ArrayList<>();
        for(SystemUser participant : listOfParticipants){

            this.participants.add(new ParticipantsOfMeeting(this,participant));
        }
        this.meetingStatus = MeetingStatus.SCHEDULE;
        this.meetingTimeStamp = MeetingTimeStamp.SCHEDULE;
    }

    public Meeting() {

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.idMeeting;
    }
}
