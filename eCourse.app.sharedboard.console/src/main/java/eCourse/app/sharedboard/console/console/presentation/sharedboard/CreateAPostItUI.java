package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.CreatePostItController;
import eCourse.app.common.console.myuser.SignupRequestUI;
import eCourse.app.common.console.teachers.TeacherPrinter;
import eCourse.domain.Course;
import eCourse.domain.SharedBoard;
import eCourse.domain.Teacher;
import eCourse.domain.postit.PostIt;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CreateAPostItUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAPostItUI.class);
    private final CreatePostItController theController = new CreatePostItController();

    @Override
    protected boolean doShow() {


        final Iterable<SharedBoard> boards = theController.allSharedBoards();
        final SelectWidget<SharedBoard> selectorBoard = new SelectWidget<>("Select a board", boards, new SystemBoardPrinter());
        selectorBoard.show();
        final SharedBoard theBoard = selectorBoard.selectedElement();

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
                // ignoring exception. assuming it is just a primary key violation
                // due to the tentative of inserting a duplicated entry
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
