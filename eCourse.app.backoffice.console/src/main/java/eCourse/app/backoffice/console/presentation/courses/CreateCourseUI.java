package eCourse.app.backoffice.console.presentation.courses;

import eCourse.course.application.CreateCourseController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateCourseUI extends AbstractUI {

    private final CreateCourseController theController = new CreateCourseController();
    @Override
    protected boolean doShow() {
        final String name = Console.readNonEmptyLine("Name","The name should not be empty");
        final String edition = Console.readNonEmptyLine("Edition","The edition should not be empty");
        final String description = Console.readNonEmptyLine("Description","The description should not be empty");

        // this is a default state for when create a course
        String state = "Open";


        theController.createCourse(name,edition,description,state);
        return false;
    }


    private String [] buildCourseStates() {
        final String [] courseStates = theController.getCourseStates();
        return courseStates;
    }

    @Override
    public String headline() {
        return "Create new course";
    }
}
