package eCourse;

import eCourse.domain.BoardUpdateEvent;
import eCourse.domain.Notification;
import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;


@Component
@UseCaseController
public class ArchiveABoardController extends Thread {
    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    private final Object mutex = new Object(); // For synchronization

    public Iterable<SharedBoard> listBoardsByUser() {
        Iterable<SharedBoard> boardIterable = listSharedBoardService.listBoardsByUser();
        return IteratorUtils.toList(boardIterable.iterator());
    }


    public boolean changeArchive(SharedBoard board, SystemUser user) {

        return board.updateArchive(true, user);
    }

    public void archiveBoard(SharedBoard board, SystemUser user) {
        new Thread(() -> {
            synchronized (mutex) {
                BoardUpdateEvent event = new BoardUpdateEvent(board, user);
                Notification userNotification = new Notification(event, user);
                PersistenceContext.repositories().sharedBoards().save(board);
                PersistenceContext.repositories().notifications().save(userNotification);
            }
        }).start();

    }
}
