package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.ViewSharedBoardUpdatesController;
import eCourse.domain.enums.AccessType;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class ViewSharedBoardUpdatesUI extends AbstractUI {

    private ViewSharedBoardUpdatesController theController = new ViewSharedBoardUpdatesController();

    @Override
    protected boolean doShow() {

        Map<SharedBoardTitle, AccessType> map = new HashMap<>();
        Set<SharedBoard> myBoards = theController.listOfAllUserBoards(map);

        if (((Collection<?>) myBoards).size() == 0) {
            System.out.println("You have no Boards!");
            return false;
        }

        System.out.println("Which one you want to update? Press 0 to exit:");

        final Map<Integer, SharedBoard> hashmap = new HashMap<>();

        int selectedOption = showInfo(myBoards, hashmap);

        SharedBoard board = hashmap.get(selectedOption); // ----> Objecto para passar ao HTTP

        //APAGAR O QUE ESTÁ ABAIXO DISTO QUANDO SE PASSAR O OBJECTO PARA O HTTP
        if (!board.archive()) {
            System.out.println("The board " + board.boardTitle().toString() + " has " + board.numberOfColumns() + " columns and " +
                    board.numberOfRows() + " rows and is not archived.");
        } else {
            System.out.println("The board " + board.boardTitle().toString() + " has " + board.numberOfColumns() + " columns and " +
                    board.numberOfRows() + " rows and is archived.");
        }
        // ATÉ AQUI!

        return false;
    }

    protected int showInfo(Set<SharedBoard> myBoards, Map<Integer, SharedBoard> map) {
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
