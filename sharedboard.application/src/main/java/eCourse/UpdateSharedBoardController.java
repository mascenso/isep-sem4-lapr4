package eCourse;

import eCourse.domain.*;
import eCourse.domain.enums.AccessType;
import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Component
@UseCaseController
public class UpdateSharedBoardController extends Thread {

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    private final Object mutex = new Object(); // For synchronization


    public Iterable<SharedBoard> listOfAllUserBoards(Map<SharedBoardTitle, AccessType> map) {
        return listSharedBoardService.listOfAllUserBoards(map);
    }


    public void updateSharedBoard(int numberOfRows, int numberOfColumns, String[] columnNames, String[] rowNames, SharedBoard board, SystemUser user) {

        Thread shareThread = new Thread(() -> {
            synchronized (mutex) {
                board.changeNumberOfRows(numberOfRows);
                board.changeNumberOfColumns(numberOfColumns);

                List<SBColumn> columns = new ArrayList<>();
                for (String columnName : columnNames) {
                    columns.add(new SBColumn(columnName));
                }
                board.changeColumns(columns);

                List<SBRow> rows = new ArrayList<>();
                for (String rowName : rowNames) {
                    rows.add(new SBRow(rowName));
                }

                board.changeRows(rows);

                PersistenceContext.repositories().sharedBoards().save(board);

                BoardUpdateEvent event = new BoardUpdateEvent(board, user);
                Notification userNotification = new Notification(event, user);

                if (user.sameAs(board.owner())){
                    PersistenceContext.repositories().notifications().save(userNotification);
                }else{
                    PersistenceContext.repositories().notifications().save(userNotification);
                    PersistenceContext.repositories().notifications().save(new Notification(event, board.owner()));
                }



                Iterable<SystemUser> users = listSharedBoardService.getUsersWithSharedBoard(board);
                for (SystemUser sharedUser : users) {
                    if (!sharedUser.sameAs(user) && !sharedUser.sameAs(board.owner())) {
                        Notification sharedBoardUpdateNotification = new Notification(event, sharedUser);
                        PersistenceContext.repositories().notifications().save(sharedBoardUpdateNotification);
                    }
                    // PersistenceContext.repositories().notifications().save(notif);
                }
            }
        });
        shareThread.start();
    }

    public void changeArchive(SharedBoard board) {
        board.updateArchive(true);

    }
}
