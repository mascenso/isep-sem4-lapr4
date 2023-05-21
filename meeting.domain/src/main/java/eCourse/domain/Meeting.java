package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    /**
     * This is a constructor to create a new meeting
     * @param name name of meeting
     * @param schedule date of meeting
     * @param listOfParticipants participants of meeting
     * @param duration duration of meeting
     */
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

    public Designation designation(){
        return this.title;
    }
    public List<ParticipantsOfMeeting> participants(){return this.participants;}

    /**
     * Return the date of meeting
     * @return
     */
    public Date dateOfMeeting (){return this.schedule;}

    /**
     * Usefull method to compare 2 objects meeting
     * @param other
     * @return
     */
    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Meeting otherMeeting = (Meeting) other;

        return Objects.equals(title, otherMeeting.title);
    }

    /**
     * Returns the id of meeting
     * @return
     */
    @Override
    public Long identity() {
        return this.idMeeting;
    }
}
