package eCourse;

import eCourse.domain.Meeting;
import eCourse.domain.Notification;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@ApplicationService
public class ListNotificationsService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<Notification> allNotifications() throws IOException {

        //Make request
        return PersistenceContext.repositories().notifications().findAll();
    }


    public List<Notification> getMyNotifications(){
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<Notification> notificationIterable = PersistenceContext.repositories().notifications().findByUser(user.get().identity());
        List<Notification> userNotification = IteratorUtils.toList(notificationIterable.iterator());

        return  userNotification;
    }
}
