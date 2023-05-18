package eCourse.app.backoffice.console.presentation.exam;

import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eCourse.exam.application.UpdateExamController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpdateExamUI extends AbstractUI {

    UpdateExamController theController = new UpdateExamController();

    @Override
    protected boolean doShow() {

        List<Course> listOfCourses = theController.getOpenCourses();

        final Map<Integer, Designation> courseMap = new HashMap<>();
        System.out.println("Select the Course:");

        int selectedOption = showItems(listOfCourses, courseMap);
        final Course selectedCourse = listOfCourses.get(selectedOption - 1);

        List<Exam> listOfExamsByCourse = theController.getExamsByCourse(selectedCourse);
        final Map<Long, ExamTitle> examMap = new HashMap<>();
        System.out.println("Select the Exam:");

        int selectedExam = showItems(listOfExamsByCourse, examMap);

        String title = examMap.get((long) selectedExam).toString();

        Exam selexam = theController.getExamByTitle(ExamTitle.valueOf(title));

        //Exam selecteExam = theController.getExamByTitle(title);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date newOpenDate, newCloseDate;

        Date currentOpenDate = theController.getExamOpenDate(selexam);
        Date currentCloseDate = theController.getExamCloseDate(selexam);
        System.out.printf("Current open date: " + currentOpenDate + "\nCurrent close date: " + currentCloseDate + "\n");

        String openDateString = Console.readNonEmptyLine("Insert the new open date (yyyy-MM-dd)", "The date cannot be empty!");
        String closeDateString = Console.readNonEmptyLine("Insert the new close date (yyyy-MM-dd)", "The date cannot be empty!");

        try {
            newOpenDate = format.parse(openDateString);
            newCloseDate = format.parse(closeDateString);
            final String path = Console.readNonEmptyLine("Insert the path to the file:", "The path cannot be empty!");
            File examFile = new File(path);

            theController.updateExam(selexam,newOpenDate, newCloseDate, examFile);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    protected <T, K, V> int showItems(Iterable<T> itemList, Map<K, V> hashmap) {
        int index = 1;
        for (T item : itemList) {
            if (item instanceof Course) {
                Course course = (Course) item;
                hashmap.put((K) Integer.valueOf(index), (V) course.identity());
                System.out.println(index + ". " + course.identity());
            } else if (item instanceof Exam) {
                Exam exam = (Exam) item;
                hashmap.put((K) exam.getExamId(), (V) exam.identity());
                System.out.println(index + ". " + exam.identity());
            }
            index++;
        }
        int option = Console.readOption(1, index - 1, 0);
        return option;
    }


    @Override
    public String headline() {
        return "Update Exam";
    }
}
