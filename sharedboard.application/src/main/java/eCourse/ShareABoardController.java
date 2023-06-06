package eCourse;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@UseCaseController
public class ShareABoardController {

    private SharedBoard sb;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private Notification notification;

    private Object mutex = new Object(); // Mutex object for synchronization

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> getMyBoards() {
        return listSharedBoardService.listBoardsByUser();
    }

    public Iterable<SystemUser> allUsers() {
        return PersistenceContext.repositories().users().findAll();
    }

    public Map<Integer, AccessType> getAccessTypes() {
        return AccessType.getListOfAccessTypes();
    }

    public void createShareBoardUsers(Map<SystemUser, AccessType> usersWithPermissions, SharedBoardTitle board) {
        Thread shareThread = new Thread(() -> {
            synchronized (mutex) {
                for (Map.Entry<SystemUser, AccessType> user : usersWithPermissions.entrySet()) {
                    SharedBoardUser boardShared = sb.createShareBoardUsers(user.getKey(), board, user.getValue());
                    Notification notif = notification.getNotification();
                    PersistenceContext.repositories().notifications().save(notif);
                    PersistenceContext.repositories().sharedBoardUser().save(boardShared);
                }
            }
        });
        shareThread.start();
    }
}
