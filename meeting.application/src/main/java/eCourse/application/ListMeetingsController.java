package eCourse.application;

import eCourse.domain.Meeting;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class ListMeetingsController {

    private ListMeetingsService service = new ListMeetingsService();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();



    public Iterable<Meeting> listMeetingsByUser(){
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        return service.getMeetingsByUser(user);
    }
}
