package eCourse.app.sharedboard.console.console.presentation.sharedboard;


import eCourse.domain.Coluna;
import eCourse.CreateSharedBoardController;
import eCourse.domain.Linha;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardColumnAndRow;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class SharedBoardUI extends AbstractUI {

    private final CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    @Override
    protected boolean doShow() {
        final String title = Console.readLine("Title: ");
        final int numberOfColumns = Integer.parseInt(Console.readLine("Number of Columns"));
        final String[] columnNames = new String[numberOfColumns];
        final int numberOfRows = Integer.parseInt(Console.readLine("Number of Rows"));
        final String[] rowNames = new String[numberOfRows];

        final SharedBoard sharedBoardColumnAndRow = new SharedBoard(numberOfRows, numberOfColumns);
        for (int i = 0; i < numberOfColumns; i++) {
            columnNames[i] = Console.readLine("Column name " + (i+1) + " : ");
        }


        for (int i = 0; i < numberOfRows; i++) {
            rowNames[i] = Console.readLine("Row name " + (i+1) + ": " );
        }

        List<Coluna> columns = new ArrayList<>();
        for (String columnName : columnNames){
            columns.add(new Coluna(columnName));
        }

        List<Linha> rows = new ArrayList<>();
        for (String rowName : rowNames){
            rows.add(new Linha(rowName));
        }

        try {
            createSharedBoardController.addSharedBoard(title, numberOfColumns, numberOfRows, columns, rows);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("This title is already in use");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create Shared Board";
    }
}
