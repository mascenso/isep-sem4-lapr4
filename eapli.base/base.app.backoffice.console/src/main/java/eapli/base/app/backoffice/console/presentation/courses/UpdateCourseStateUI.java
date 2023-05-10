package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.UpdateCourseStateController;
import eapli.base.domain.Course;
import eapli.base.domain.CourseStates;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

public class UpdateCourseStateUI extends AbstractUI {

    private final UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();

    @Override
    protected boolean doShow() {
        final String designationName = Console.readNonEmptyLine("Course Designation","The designation should not be empty");

        final Optional<Course> optionalCourse = updateCourseStateController.findCourseByDesignation(designationName);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Course: " + course.designation().toString());
            System.out.println("Current State: " + course.state().toString());

            String newState = null;

            do {
                newState = showStates();
            } while(newState == null);

            updateCourseStateController.updateCourseState(designationName, newState);

            return true;
        } else {
            System.out.println("Course not found!");
            return false;
        }
    }

    private String showStates(){
        final String [] courseStates = CourseStates.stateValues();
        for (int i = 0; i < courseStates.length; i++) {
            System.out.println("("+i+") " + courseStates[i]);
        }
        int choose = Console.readInteger("New State");
        return choose < courseStates.length ? courseStates[choose] : null;
    }

    @Override
    public String headline() {
        return "Update Course State";
    }
}
