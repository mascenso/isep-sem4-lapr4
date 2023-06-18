package eCourse;

import eCourse.domain.*;
import eCourse.domain.enums.AccessType;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@UseCaseController
public class ShareABoardController extends Thread {

    private Object mutex = new Object(); // Mutex object for synchronization

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> getMyBoards() throws IOException {
        return listSharedBoardService.listBoardsByUser();
    }

    public Iterable<SystemUser> allUsers() throws IOException {
        return PersistenceContext.repositories().users().findAll();
    }

    public Map<Integer, AccessType> getAccessTypes() {
        return AccessType.getListOfAccessTypes();
    }

    public void createShareBoardUsers(Map<SystemUser, AccessType> usersWithPermissions, SharedBoard board) {

        new Thread(() -> {
            synchronized (mutex) {
                for (Map.Entry<SystemUser, AccessType> user : usersWithPermissions.entrySet()) {
                    SharedBoardUser boardShared = board.createShareBoardUsers(user.getKey(), board.identity(), user.getValue());
                    BoardShareEvent event = new BoardShareEvent(boardShared);
                    Notification notif = new Notification(event);


                    PersistenceContext.repositories().notifications().save(notif);
                    PersistenceContext.repositories().sharedBoardUser().save(boardShared);
                }
            }
        }).start();
    }

    public void createShareBoardUsersNoThread(Map<SystemUser, AccessType> usersWithPermissions, SharedBoard board) {

                for (Map.Entry<SystemUser, AccessType> user : usersWithPermissions.entrySet()) {
                    SharedBoardUser boardShared = board.createShareBoardUsers(user.getKey(), board.identity(), user.getValue());
                    BoardShareEvent event = new BoardShareEvent(boardShared);
                    Notification notif = new Notification(event);

                    PersistenceContext.repositories().notifications().save(notif);
                    PersistenceContext.repositories().sharedBoardUser().save(boardShared);
                }
            }

}
