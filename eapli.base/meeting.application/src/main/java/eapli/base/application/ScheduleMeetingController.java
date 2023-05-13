package eapli.base.application;

import eapli.base.domain.Meeting;
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
        Meeting meeting =new Meeting(Designation.valueOf(name),participants,schedule,duration);
        PersistenceContext.repositories().meetings().save(meeting);
        return true;
    }
}
