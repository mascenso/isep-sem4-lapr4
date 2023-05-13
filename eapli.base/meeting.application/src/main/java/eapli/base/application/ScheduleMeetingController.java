package eapli.base.application;

import eapli.base.domain.Meeting;
import eapli.base.domain.MeetingBuilder;
import eapli.base.domain.ParticipantsOfMeeting;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Date;
import java.util.List;

public class ScheduleMeetingController {

    public Iterable<SystemUser> allUsers(){

        return PersistenceContext.repositories().users().findAll();
    }
    public boolean scheduleMeeting (String name, List <SystemUser> participants, Date schedule, int duration) {
        Meeting meeting =new MeetingBuilder().named(Designation.valueOf(name)).duration(duration).participants(participants).schedule(schedule).build();
        PersistenceContext.repositories().meetings().save(meeting);
        return true;
    }

    public boolean validateSchedule (List<SystemUser> participants, Date dateOfSchedule,int duration){
        return new ValidateSchedule().validateScheduleForAllParticipants(participants,dateOfSchedule, duration);
    }
}
