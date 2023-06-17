package eCourse.app.sharedboard.console.console.presentation.sharedboard;

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
    private final CreatePostItController theController = new CreatePostItController();

    @Override
    protected boolean doShow() {

        final Iterable<SharedBoard> boards = theController.allSharedBoards();
        if (((Collection<?>) boards).size() == 0) {
            System.out.println("No boards available!");
            return false;
        }
        final SelectWidget<SharedBoard> selectorBoard = new SelectWidget<>("Select a board", boards, new SystemBoardPrinter());
        selectorBoard.show();
        final SharedBoard theBoard = selectorBoard.selectedElement();

        final Iterable<SharedBoardCell> cells = theController.sharedBoardCells(theBoard);

        final String textContent = Console.readLine("Text Content (Optional):");
        final String imageFilename = Console.readLine("Img filename (Optional):");

        Integer x = Integer.parseInt(Console.readLine("X:"));
        Integer y = Integer.parseInt(Console.readLine("Y:"));

        final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(imageFilename);

        if (inputStream == null) {
            System.out.println("Could not load image " + imageFilename);
            // fallback to registration without image
            theController.registerPostIt(theBoard, x, y, textContent);
        } else {
            try {
                theController.registerPostIt(theBoard, x, y, textContent , inputStream);
                System.out.println("PostIt created successfully");

                //System.out.println(postIt.toString());

            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That postIt already exists");

            } catch (final IOException e) {
                System.out.println("There was a problem loading the image file");
            }
        }

        return false;
    }


    @Override
    public String headline() {
        return "Create new post-It";
    }
}
