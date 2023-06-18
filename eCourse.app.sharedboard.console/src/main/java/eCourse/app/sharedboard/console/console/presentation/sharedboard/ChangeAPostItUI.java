package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.ChangePostItController;
import eCourse.CreatePostItController;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardCell;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/*
The user who created a post in a cell can change that post. It may change its contents or
move the post into a free cell.
 */
public class ChangeAPostItUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeAPostItUI.class);
    private final ChangePostItController theController = new ChangePostItController();

    @Override
    protected boolean doShow() {

        /* Shows all the cells owned by the user */
        final Iterable<SharedBoardCell> cells = theController.ownedSharedBoardCells();
        if (((Collection<?>) cells).size() == 0) {
            System.out.println("No cells available!");
            return false;
        }
        final SelectWidget<SharedBoardCell> selectorCell = new SelectWidget<>("Select a cell", cells);
        selectorCell.show();
        final SharedBoardCell theCell = selectorCell.selectedElement();

        /* Shows cell content */
        theController.showCellContent(theCell);

        switch (Console.readInteger("1. Change post\n2. Move post\n0. Exit")) {
            case 1:
                /* Change post */
                changePost(theCell);
                break;
            case 2:
                /* Move post */
                movePost(theCell);
                break;
            case 0:
                return false;
            default:
                System.out.println("Invalid option!");
                break;
        }
        return false;
    }

    private void movePost(SharedBoardCell theCell) {
        /* Shows all the cells owned by the user */
        final Iterable<SharedBoardCell> cells = theController.freeSharedBoardCells();
        if (((Collection<?>) cells).size() == 0) {
            System.out.println("No cells available!");
            return;
        }
        final SelectWidget<SharedBoardCell> selectorCell = new SelectWidget<>("Select a cell", cells);
        selectorCell.show();
        final SharedBoardCell newCell = selectorCell.selectedElement();

        /* Moves post */
        try {
            theController.movePost(theCell, newCell);
        } catch (ConcurrencyException | IntegrityViolationException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void changePost(SharedBoardCell theCell) {
        /* Asks for new post content */
        String newContent = Console.readLine("New content: ");

        /* Changes post content */
        try {
            theController.changePost(theCell, newContent);
        } catch (ConcurrencyException | IntegrityViolationException e) {
            LOGGER.error(e.getMessage());
        }
    }


    @Override
    public String headline() {
        return "Create new post-It";
    }
}
