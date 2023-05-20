package eCourse.app.teacher.console.presentation.question;

import eCourse.domain.Course;
import eCourse.domain.QuestionType;
import eCourse.question.application.AddExamQuestionsController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddExamQuestionsUI extends AbstractUI {

    private final AddExamQuestionsController theController = new AddExamQuestionsController();

    protected boolean doShow() {

        List<Course> listOfCourses = theController.getOpenCourses();

        final Map<Integer, Designation> hashmap = new HashMap<>();
        System.out.println("List of Open Courses, choose one:");
        int selectedOption = showCourses(listOfCourses, hashmap);

        final Course selectedCourse = listOfCourses.get(selectedOption - 1);

        Map<Integer, QuestionType> listOfQuestionTypes = theController.getAllQuestionTypes();
        showExistingTypes(listOfQuestionTypes, "Select the question type:");
        int option = Console.readOption(1, listOfQuestionTypes.size(), 0);

        String description = Console.readNonEmptyLine("Insert a  description: ", "The description cannot be empty!");

        final String questionPath = Console.readNonEmptyLine("Insert the Question's path file : ", "The path cannot be empty!");
        File questionFile = new File(questionPath);

        try {
            theController.createQuestion(questionFile, option, selectedCourse,description);
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


    protected <T> void showExistingTypes(Map<Integer, T> map, String label) {
        System.out.println(label);
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            int id = entry.getKey();
            T value = entry.getValue();
            System.out.println(id + ". " + value.toString());
        }
    }

    @Override
    public String headline() {
        return "Add Exam Questions";

    }
}
