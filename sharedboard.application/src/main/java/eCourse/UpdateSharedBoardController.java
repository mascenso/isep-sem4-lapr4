package eCourse;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@UseCaseController
public class UpdateSharedBoardController {

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> listOfAllUserBoards() {
        return listSharedBoardService.listOfAllUserBoards();
    }


    public void updateSharedBoard(int numberOfRows, int numberOfColumns, String[] columnNames, String[] rowNames, SharedBoard board) {

        board.changeNumberRows(numberOfRows);
        board.changeNumberColumns(numberOfColumns);

        List<Coluna> columns = new ArrayList<>();
        for (String columnName : columnNames){
            columns.add(new Coluna(columnName));
        }
        board.changeColumns(columns);

        List<Linha> rows = new ArrayList<>();
        for (String rowName : rowNames){
            rows.add(new Linha(rowName));
        }

        board.changeRows(rows);

        BoardShareEvent event = new BoardShareEvent(board);
        Notification notif = new Notification(event);

        PersistenceContext.repositories().notifications().save(notif);
        PersistenceContext.repositories().sharedBoards().save(board);

    }

    public void changeArchive(SharedBoard board) {
        board.updateArchive(true);

    }
}
