package eCourse.app.backoffice.console.presentation.courses;

import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.Course;
import eCourse.domain.CourseState;
import eCourse.domain.CourseStates;
import eCourse.usermanagement.domain.BaseCourseStates;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Arrays;
import java.util.Optional;

public class UpdateCourseStateUI extends AbstractUI {

    private final UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();

    @Override
    protected boolean doShow() {
        /*final String designationName = Console.readNonEmptyLine("Course Designation","The designation should not be empty");

        final Optional<Course> optionalCourse = updateCourseStateController.findCourseByDesignation(designationName);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Course: " + course.designation().toString());
            System.out.println("Current State: " + course.state().toString());


            CourseState currentState = CourseState.valueOf(String.valueOf(course.state()));

           // String atualState = String.valueOf(course.state());

            String newState = null;

            do {
                newState = showStates(currentState);
            } while(newState == null);

            updateCourseStateController.updateCourseState(designationName, newState);

            return true;
        } else {
            System.out.println("Course not found!");
            return false;
        }*/

        final String designationName = Console.readNonEmptyLine("Course Designation","The designation should not be empty");

        final Optional<Course> optionalCourse = updateCourseStateController.findCourseByDesignation(designationName);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Course: " + course.designation().toString());
            System.out.println("Current State: " + course.state().toString());

            String atualState = String.valueOf(course.state());
            String newState = null;

            do {
                newState = showStates(atualState);
            } while(newState == null);

            updateCourseStateController.updateCourseState(designationName, newState);

            return true;
        } else {
            System.out.println("Course not found!");
            return false;
        }
    }

    private String showStates(String atualState){

        /*final String [] courseStates = Arrays.stream(BaseCourseStates.allCourseStates()).map(CourseState::toString).toArray(String[]::new);
        for (int i = 0; i < courseStates.length; i++) {
            System.out.println("("+i+") " + courseStates[i]);
        }
        int choose = Console.readInteger("New State");
        return choose < courseStates.length ? courseStates[choose] : null; */

        String[] courseStates = null;
        switch (atualState) {
            case "Close":
                courseStates = new String[] { "Open" };
                break;
            case "Open":
                courseStates = new String[] { "Enroll" };
                break;
            case "Enroll":
                courseStates = new String[] { "Progress" };
                break;
            case "Progress":
                courseStates = new String[] { "Close" };
                break;



        }
        //final String [] courseStates = CourseState.valueOf();
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
