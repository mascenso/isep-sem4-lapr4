package eCourse.application;

import eCourse.domain.Meeting;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class CancelMeetingController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    SystemUser user  = authz.session().get().authenticatedUser();

    ListMeetingsService service = new ListMeetingsService();

    public List<Meeting> ListMeetingsOfUSer() {
        return service.ListMeetingThatUserCreated(user);

    }

    public void cancelMeeting(Meeting meeting) {
        meeting.cancelMeeting();
        PersistenceContext.repositories().meetings().save(meeting);
    }
}
