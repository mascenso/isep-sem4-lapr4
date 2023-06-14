package eCourse;

import eCourse.domain.*;
import eCourse.domain.enums.AccessType;
import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
@UseCaseController
public class UpdateSharedBoardController {

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    private Object mutex = new Object(); // Mutex object for synchronization


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

                BoardUpdateEvent event = new BoardUpdateEvent(board, user);
                Notification notif = new Notification(event, user);

                PersistenceContext.repositories().sharedBoards().save(board);
                PersistenceContext.repositories().notifications().save(notif);
            }
        });
        shareThread.start();
    }

    public void changeArchive(SharedBoard board) {
        board.updateArchive(true);

    }
}
