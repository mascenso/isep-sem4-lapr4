package eapli.base.app.backoffice.console.presentation.sharedboard;

import eapli.base.CreateSharedBoardController;
import eapli.base.SharedBoardColumnAndRow;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class SharedBoardUI extends AbstractUI {

    private final CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    @Override
    protected boolean doShow() {
        final String title = Console.readLine("Title: ");
        final int numberOfColumns = Integer.parseInt(Console.readLine("Number of Columns"));
        final int numberOfRows = Integer.parseInt(Console.readLine("Number of Rows"));
        final SharedBoardColumnAndRow sharedBoardColumnAndRow = new SharedBoardColumnAndRow(numberOfColumns, numberOfRows);
        try {
            CreateSharedBoardController.addSharedBoard(title, sharedBoardColumnAndRow);
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
