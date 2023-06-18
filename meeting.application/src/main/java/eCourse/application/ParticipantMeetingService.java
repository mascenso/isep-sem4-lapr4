package eCourse.application;

import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;

import java.util.List;
import java.util.Optional;

public class ParticipantMeetingService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<Meeting> allMeetings(){

        return PersistenceContext.repositories().meetings().findAll();
    }

    public Iterable<ParticipantsOfMeeting> getMeetingsByUser() {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<ParticipantsOfMeeting> meetingIterable = PersistenceContext.repositories().meetingResquests().findByUsername(user.get().identity());
        List<ParticipantsOfMeeting> meetingListByUser = IteratorUtils.toList(meetingIterable.iterator());

        return  meetingListByUser;
    }

    /*public Iterable<ParticipantsOfMeeting> getParticipants(){
        Iterable<ParticipantsOfMeeting>
    }*/


}
