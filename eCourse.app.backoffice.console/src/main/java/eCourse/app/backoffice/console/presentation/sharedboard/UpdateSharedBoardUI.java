package eCourse.app.backoffice.console.presentation.sharedboard;

import eCourse.UpdateSharedBoardController;
import eCourse.domain.SharedBoard;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class UpdateSharedBoardUI extends AbstractUI {

    private UpdateSharedBoardController theController = new UpdateSharedBoardController();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();


    @Override
    protected boolean doShow() {

        Iterable<SharedBoard> myBoards = theController.listOfAllUserBoards();

        if (((Collection<?>) myBoards).size() == 0) {
            System.out.println("You have no Boards!");
            return false;
        }

        System.out.println("Which one you want to update? Press 0 to exit:");

        final Map<Integer, SharedBoard> hashmap = new HashMap<>();

        int selectedOption = showInfo(myBoards, hashmap);

        SharedBoard board = hashmap.get(selectedOption);

        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);

        String answer;
        if (board.owner().sameAs(user.get()))
            if (!board.archive()) {
                System.out.println("Do you want to archive the board?");
                answer = Console.readLine("Type yes or no");
                if (answer.equalsIgnoreCase("yes")) {
                    theController.changeArchive(board);
                    return false;
                }
            }


        System.out.println("This board has " + board.numberOfColumns() + " columns and " +
                board.numberOfRows() + " rows.");

        int columns, rows;
        do {
            columns = Integer.parseInt(Console.readLine("Insert the number of columns (min 1, max 10): "));
        } while ((columns < 1) || (columns > 10));
       // theController.changeNumberOfColumns(columns, board);

        do {
            rows = Integer.parseInt(Console.readLine("Insert the number of rows (min 1, max 20):"));
        } while ((rows < 1) || (rows > 20));

        //theController.changeNumberOfRows(rows, board);

        final String[] columnNames = new String[columns];
        final String[] rowNames = new String[rows];

        for (int i = 0; i < columns; i++) {
            columnNames[i] = Console.readLine("Column " + (i + 1) + " name:");
        }

        for (int i = 0; i < rows; i++) {
            rowNames[i] = Console.readLine("Row " + (i + 1) + " name:");
        }

        theController.updateSharedBoard(rows, columns, columnNames, rowNames, board);

        return false;
}

    protected int showInfo(Iterable<SharedBoard> myBoards, Map<Integer, SharedBoard> map) {
        int index = 1;
        for (SharedBoard sb : myBoards) {
            map.put(index, sb);
            System.out.println(index + ". " + sb.identity());
            index++;
        }
       return Console.readOption(1, index - 1, 0);
    }

    @Override
    public String headline() {
        return "Update Shared Board";
    }
}
