package eapli.base.domain;


import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingBuilder implements DomainFactory<Meeting> {

    private Meeting theMeeting;

    private Designation name;


    private List<SystemUser> participants;

    private int duration;

    private Date schedule;

    private MeetingStatus meetingStatus = MeetingStatus.SCHEDULE;

    private MeetingTimeStamp meetingTimeStamp = MeetingTimeStamp.SCHEDULE;

    public MeetingBuilder named(final Designation name){
        this.name = name;
        return this;
    }

    public MeetingBuilder duration (final int duration){
        this.duration = duration;
        return this;
    }

    public MeetingBuilder schedule (final Date schedule){
        this.schedule = schedule;
        return this;
    }

    public MeetingBuilder meetingStatus (final MeetingStatus meetingStatus){
        this.meetingStatus = meetingStatus;
        return this;
    }

    public MeetingBuilder meetingTimeStamp (final MeetingTimeStamp meetingTimeStamp){
        this.meetingTimeStamp = meetingTimeStamp;
        return this;
    }

    public MeetingBuilder participants(final List<SystemUser> participants){
        this.participants = participants;
        return this;
    }
    private Meeting buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theMeeting != null) {
            return theMeeting;
        }
        if (name != null && duration >0 && schedule != null && participants!= null && meetingStatus != null && meetingTimeStamp !=null) {

            theMeeting = new Meeting(name,schedule,participants,duration);

            return theMeeting;
        }
        throw new IllegalStateException();

    }
    @Override
    public Meeting build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theMeeting = null;
        return ret;
    }
}
