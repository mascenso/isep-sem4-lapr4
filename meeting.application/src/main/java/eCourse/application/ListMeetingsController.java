package eCourse.application;

import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class ListMeetingsController {

    private ListMeetingsService service = new ListMeetingsService();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();



    public Iterable<Meeting> listMeetingsByUser(){
        return service.getMeetingsByUser();
    }

    public Iterable<ParticipantsOfMeeting> participantsOfMeeting(Meeting meeting){
        return service.getParticipantsOfMeeting(meeting);
    }

    /*public Iterable<ParticipantsOfMeeting> participantsByMeeting(Meeting meeting) {
        return PersistenceContext.repositories().meetingResquests().findByMeeting(meeting);
    }*/
}
