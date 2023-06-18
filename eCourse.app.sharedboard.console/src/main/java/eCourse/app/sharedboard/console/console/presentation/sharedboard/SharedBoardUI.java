package eCourse.app.sharedboard.console.console.presentation.sharedboard;


import eCourse.domain.SBColumn;
import eCourse.CreateSharedBoardController;
import eCourse.domain.SBRow;
import eCourse.domain.SharedBoard;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
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
            columnNames[i] = Console.readLine("SBColumn name " + (i+1) + " : ");
        }


        for (int i = 0; i < numberOfRows; i++) {
            rowNames[i] = Console.readLine("SBRow name " + (i+1) + ": " );
        }

        List<SBColumn> columns = new ArrayList<>();
        for (String columnName : columnNames){
            columns.add(new SBColumn(columnName));
        }

        List<SBRow> rows = new ArrayList<>();
        for (String rowName : rowNames){
            rows.add(new SBRow(rowName));
        }

        try {
            createSharedBoardController.addSharedBoard(title, numberOfColumns, numberOfRows, columns, rows);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("This title is already in use");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create Shared Board";
    }
}
