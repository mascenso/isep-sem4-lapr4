package eCourse.app.teacher.console.presentation.exam;


import eCourse.domain.*;
import eCourse.exam.application.CreateExamController;
import eCourse.question.application.AddUpdateExamQuestionsController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateExamUI extends AbstractUI {

    private final CreateExamController theController = new CreateExamController();

    private final AddUpdateExamQuestionsController theQuestionsController = new AddUpdateExamQuestionsController();


    protected boolean doShow() {
        List<SequenceSection> listOfSections = new ArrayList<>();
        final Integer numberOfSections = Integer.valueOf(Console.readNonEmptyLine("Insert number of sections:", "The number of sections should not be empty!"));

        for (int i = 0; i < numberOfSections; i++) {
            final String SeqDescription = Console.readLine("Insert section description (optional):");
            List<Question> questions = new ArrayList<>();
            final Integer numberOfQuestions = Integer.valueOf(Console.readNonEmptyLine("Insert number of questions for this section:", "The number of questions should not be empty!"));

            for (int j = 0; j < numberOfQuestions; j++) {
                Map<Integer, QuestionType> listOfQuestionTypes = theQuestionsController.getAllQuestionTypes();
                showExistingTypes(listOfQuestionTypes, "Select the question type:");

                int option = Console.readOption(1, listOfQuestionTypes.size(), 0);
                final String question = Console.readNonEmptyLine("Insert the Question:", "The question cannot be empty!");

                Question newQuestion = createQuestions(question, option);
                questions.add(newQuestion);
            }

            SequenceSection seqSection = theController.createSections(i, SeqDescription, questions);
            listOfSections.add(seqSection);
        }

        final String headerDescription = Console.readLine("Insert header description (optional):");

        Map<Integer, FeedbackType> listOfFeedbackTypes = theController.getAllFeedbackTypes();
        showExistingTypes(listOfFeedbackTypes, "Select the feedback type option:");
        final int feedbackTypeOption = Console.readOption(1, listOfFeedbackTypes.size(), 0);

        Map<Integer, GradeType> listOfGradeTypes = theController.getAllGradeTypes();
        showExistingTypes(listOfGradeTypes, "Select the grade type option");
        final int gradeTypeOption = Console.readOption(1, listOfGradeTypes.size(), 0);

        Header header = theController.createHeader(headerDescription, feedbackTypeOption, gradeTypeOption);

       // Date openDate = Console.readDate("Insert the open date (yyyy/MM/dd)", "The date cannot be empty!");
       // Date closeDate = Console.readDate("Insert the close date (yyyy/MM/dd)", "The date cannot be empty!");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date openDate = null;
        Date closeDate = null;
        try {
            String openDateString = Console.readNonEmptyLine("Insert the open date (yyyy-MM-dd)", "The date cannot be empty!");
            String closeDateString = Console.readNonEmptyLine("Insert the close date (yyyy-MM-dd)", "The date cannot be empty!");
            openDate = format.parse(openDateString);
            closeDate = format.parse(closeDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format, please try again.");
        }

        final String examTitle = Console.readNonEmptyLine("Insert the Exam Title:", "The title cannot be empty!");

        Iterable<Course> listOfCourses = theController.getOpenCourses();
        final Map<Integer, Designation> hashmap = new HashMap<>();
        System.out.println("List of Open Courses:");
        int selectedOption = showCourses(listOfCourses, hashmap);
        List<Course> coursesList = new ArrayList<>();
        listOfCourses.forEach(coursesList::add);
        final Course selectedCourse = coursesList.get(selectedOption - 1);

       // final Course selectedCourse = theController.findCourse(hashmap.get(selectedOption));

        try {
            theController.createExam(selectedCourse, examTitle, openDate, closeDate, header, listOfSections);
        } catch (final IntegrityViolationException e) {
            System.out.println("You tried to enter an exam which already exists in the database.");
        } catch (final ConcurrencyException e) {
            System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
        return false;
    }


    protected <T> void showExistingTypes(Map<Integer, T> map, String label) {
        System.out.println(label);
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            int id = entry.getKey();
            T value = entry.getValue();
            System.out.println(id + ". " + value.toString());
        }
        System.out.println("0. Exit");
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

    protected Question createQuestions(String question, int option) {
        Question newQuestion;

        switch (option) {
            case 1:
                final String[] matchingOptions = Console.readNonEmptyLine("Insert Matching Options (separate by comma)", "The options cannot be empty!").split(",");
                final String[] matchingAnswers = Console.readNonEmptyLine("Insert Matching Answers (separate by comma)", "The answers cannot be empty!").split(",");
                final String[] matchingSolution = new String[]{Console.readNonEmptyLine("Insert Solution (separate by comma)", "The question needs a solution!")};
                newQuestion = theQuestionsController.createMatchingQuestion(question, matchingSolution, matchingOptions, matchingAnswers, option);
                break;
            case 2:
                final String[] multipleChoice = Console.readNonEmptyLine("Insert Multiple Choice Options (separate by comma)", "The options cannot be empty!").split(",");
                final int solutionIndex = Console.readInteger("Insert the index of the Correct Option (starting from 1)") - 1;
                newQuestion = theQuestionsController.createMultipleChoiceQuestion(question, String.valueOf(solutionIndex), multipleChoice, option);
                break;
            case 3:
                final String solution = Console.readNonEmptyLine("Insert Solution", "The question needs a solution!");
                final String isCaseSensitive = Console.readNonEmptyLine("Is it Case Sensitive?\n Type 'yes' or 'no' ", "Case sensitive needs to be defined!");
                newQuestion = theQuestionsController.createShortAnswerQuestion(question, solution, isCaseSensitive, option);
                break;
            case 4:
                final double acceptanceError = Console.readDouble("Insert Acceptence Error (positive number)");
                final String[] answerOptions = Console.readNonEmptyLine("Insert Answer Options (separate by comma)", "The options cannot be empty!").split(",");
                final String[] solutions = new String[]{Console.readNonEmptyLine("Insert Solutions (separate by comma)", "The question needs a solution!")};
                newQuestion = theQuestionsController.createNumericalQuestion(question, solutions, answerOptions, acceptanceError, option);
                break;
            case 5:
                final String[] wordsOptions = Console.readNonEmptyLine("Insert Words (separate by comma)", "The words cannot be empty!").split(",");
                final String[] WordSolutions = new String[]{Console.readNonEmptyLine("Insert Solutions (separate by comma)", "The question needs a solution!")};
                newQuestion = theQuestionsController.createSelectMissingWordsQuestion(question, WordSolutions, wordsOptions, option);
                break;
            case 6:
                final String shortSolution = Console.readNonEmptyLine("Insert Solution", "The question needs a solution!");
                newQuestion = theQuestionsController.createTrueOrFalseQuestion(question, shortSolution, option);
                break;
            default:
                return null;
        }

        return newQuestion;
    }

    @Override
    public String headline() {
        return "Create/Update Exam";

    }
}