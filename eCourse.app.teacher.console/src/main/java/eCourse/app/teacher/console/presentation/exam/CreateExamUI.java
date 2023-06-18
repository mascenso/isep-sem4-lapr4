package eCourse.app.teacher.console.presentation.exam;


import eCourse.domain.*;
import eCourse.exam.application.CreateExamController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreateExamUI extends AbstractUI {
    private final CreateExamController theController = new CreateExamController();

    protected boolean doShow() {

        final String title = Console.readNonEmptyLine("Insert the Exam title:", "The title cannot be empty!");

        List<Course> listOfCourses = theController.getInProgressCourses();

        final Map<Integer, Designation> hashmap = new HashMap<>();



        System.out.println("List of Open Courses:");
        int selectedOption = showCourses(listOfCourses, hashmap);
        final Course selectedCourse = listOfCourses.get(selectedOption - 1);

        try {

            Date openDate = Console.readDate("Insert the open date (dd/MM/yyyy)", "dd/MM/yyyy");
            Date closeDate;

            do {
                closeDate = Console.readDate("Insert the close date (dd/MM/yyyy). It cannot be before the start date!", "dd/MM/yyyy");
            } while (closeDate.compareTo(openDate) < 0);

            final String path = Console.readNonEmptyLine("Insert the path to the file:", "The path cannot be empty!");
            File examFile = new File(path);

            if (!examFile.exists()) {
                throw new FileNotFoundException("The file doesn't exist!");
            }

            Teacher loggedTeacher = theController.getCurrentTeacher();
            theController.createExam(selectedCourse, loggedTeacher, title, openDate, closeDate, examFile);
        } catch (final IntegrityViolationException e) {
            System.out.println("You tried to enter an exam which already exists in the database.");
        } catch (final ConcurrencyException e) {
            System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist! Returning to main menu!");
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