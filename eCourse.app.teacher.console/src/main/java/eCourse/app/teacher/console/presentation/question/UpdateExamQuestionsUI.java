package eCourse.app.teacher.console.presentation.question;

import eCourse.domain.Course;
import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eCourse.question.application.UpdateExamQuestionsController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateExamQuestionsUI extends AbstractUI {
    private final UpdateExamQuestionsController theController = new UpdateExamQuestionsController();

    @Override
    protected boolean doShow() {

        List<Course> listOfCourses = theController.getOpenCourses();
        final Map<Integer, Designation> hashmap = new HashMap<>();
        int selectedOption = showInformation(listOfCourses, hashmap, "List of Open Courses, choose one:");

        final Course selectedCourse = listOfCourses.get(selectedOption - 1);

        Map<Integer, QuestionType> listOfQuestionTypes = theController.getAllQuestionTypes();
        showExistingTypes(listOfQuestionTypes, "Select the question type:");
        int option = Console.readOption(1, listOfQuestionTypes.size(), 0);

        QuestionType selectedQuestionType = theController.getQuestionType(option);

        List<Question> listOfQuestions = theController.getQuestionByTypeAndCourse(selectedQuestionType, selectedCourse);
        final Map<Integer, Question> questionMap = new HashMap<>();

        int selectedQuestion = showInfo(listOfQuestions, questionMap, "List of Questions, choose one:");

        Question question = listOfQuestions.get(selectedQuestion-1);


        final String questionPath = Console.readNonEmptyLine("Insert the new Question's file : ", "The path cannot be empty!");
        File questionFile = new File(questionPath);

        try {
            theController.updateQuestion(question, questionFile, selectedQuestionType, selectedCourse);
        } catch (final ConcurrencyException e) {
            System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
        return false;
    }


    private int showInfo(List<Question> itemList, Map<Integer, Question> hashmap, String label) {
        System.out.println(label);
        int index = 1;
        for (Question qt : itemList) {
            hashmap.put(index, qt);
            System.out.println(index + ". " + qt.getQuestionDescription());
            index++;
        }
        int option = Console.readOption(1, index - 1, 0);
        return option;
    }


    protected int showInformation(Iterable<Course> listOfCourses, Map<Integer, Designation> hashmap, String label) {
        int index = 1;
        System.out.println(label);
        for (Course course : listOfCourses) {
            hashmap.put(index, course.identity());
            System.out.println(index + ". " + course.identity());
            index++;
        }
        return Console.readOption(1, index - 1, 0);
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
        return "Update Exam Questions";
    }
}
