package eCourse.application;

import eCourse.domain.Meeting;
import eCourse.domain.MeetingBuilder;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Date;
import java.util.List;

public class ScheduleMeetingController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    public Iterable<SystemUser> allUsers(){

        return PersistenceContext.repositories().users().findAll();
    }
    public boolean scheduleMeeting (String name, List <SystemUser> participants, Date schedule, int duration) {
        SystemUser user  = authz.session().get().authenticatedUser();
        Meeting meeting =new MeetingBuilder().named(Designation.valueOf(name)).MeetingCreator(user).duration(duration).participants(participants).schedule(schedule).build();
        PersistenceContext.repositories().meetings().save(meeting);
        return true;
    }

    public boolean validateSchedule (List<SystemUser> participants, Date dateOfSchedule,int duration){
        return new ValidateSchedule().validateScheduleForAllParticipants(participants,dateOfSchedule, duration);
    //return true;
    }
}
