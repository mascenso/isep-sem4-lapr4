package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.CreatePostItController;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardCell;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class CreateAPostItUI extends AbstractUI {

    private final CreatePostItController theController = new CreatePostItController();

    @Override
    protected boolean doShow() {

        /* Show boards of the user */
        final Iterable<SharedBoard> boards;
        try {
            boards = theController.listBoardsByUser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (((Collection<?>) boards).size() == 0) {
            System.out.println("You have no Boards to share!");
            return false;
        }
        final SelectWidget<SharedBoard> selectorBoard = new SelectWidget<>("Select a board", boards, new SystemBoardPrinter());
        selectorBoard.show();
        final SharedBoard theBoard = selectorBoard.selectedElement();


        /* Show free cells */
        final Iterable<SharedBoardCell> cells;
        cells = theController.listFreeCells(theBoard);

        if (((Collection<?>) cells).size() == 0) {
            System.out.println("There are no free cells ");
            return false;
        }
        final SelectWidget<SharedBoardCell> selectorCell = new SelectWidget<>("Select a cell", cells, new CellPrinter());
        selectorCell.show();
        final SharedBoardCell theCell = selectorCell.selectedElement();

/*
        Integer x = Integer.parseInt(Console.readLine("X:"));
        Integer y = Integer.parseInt(Console.readLine("Y:"));
*/
        final String textContent = Console.readLine("Text Content (Optional):");
        final String imageFilename = Console.readLine("Img filename (Optional):");

        final InputStream inputStream;

        if (imageFilename.isEmpty()) {
            inputStream = null;
        } else {
            inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(imageFilename);
        }

        if (inputStream == null) {
            System.out.println("Could not load image " + imageFilename);
            // fallback to registration without image
            try {
                //theController.registerPostIt(theBoard, x, y, textContent);
                theController.registerPostIt(theCell, textContent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                //theController.registerPostIt(theBoard, x, y, textContent , inputStream);
                theController.registerPostIt(theCell, textContent, inputStream);
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
