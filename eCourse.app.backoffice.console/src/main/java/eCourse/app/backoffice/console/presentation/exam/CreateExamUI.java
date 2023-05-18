package eCourse.app.backoffice.console.presentation.exam;


import eCourse.domain.*;
import eCourse.exam.application.CreateExamController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateExamUI extends AbstractUI {
    private final CreateExamController theController = new CreateExamController();

    protected boolean doShow() {

        final String title = Console.readNonEmptyLine("Insert the Exam title:", "The title cannot be empty!");

        List<Course> listOfCourses = theController.getOpenCourses();

        final Map<Integer, Designation> hashmap = new HashMap<>();

        System.out.println("List of Open Courses:");
        int selectedOption = showCourses(listOfCourses, hashmap);
        final Course selectedCourse = listOfCourses.get(selectedOption - 1);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date openDate, closeDate;

        try {
            String openDateString = Console.readNonEmptyLine("Insert the open date (yyyy-MM-dd)", "The date cannot be empty!");
            String closeDateString = Console.readNonEmptyLine("Insert the close date (yyyy-MM-dd)", "The date cannot be empty!");
            openDate = format.parse(openDateString);
            closeDate = format.parse(closeDateString);

            final String path = Console.readNonEmptyLine("Insert the path to the file:", "The path cannot be empty!");
            File examFile = new File(path);

            theController.createExam(selectedCourse, title, openDate, closeDate, examFile);
        } catch (ParseException e) {
            System.out.println("Invalid date format, please try again.");
        } catch (final IntegrityViolationException e) {
            System.out.println("You tried to enter an exam which already exists in the database.");
        } catch (final ConcurrencyException e) {
            System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
        return false;
    }

    protected int showCourses(Iterable<Course> listOfCourses, Map<Integer, Designation> hashmap) {
        int index = 1;
        for (Course course : listOfCourses) {
            hashmap.put(index, course.identity());
            System.out.println(index + ". " + course.identity());
            index++;
        }
        int option = Console.readOption(1, index - 1, 0);
        return option;
    }

    @Override
    public String headline() {
        return "Create Exam";

    }
}