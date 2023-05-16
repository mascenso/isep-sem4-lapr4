package eCourse.app.backoffice.console.presentation.question;

import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eCourse.question.application.AddUpdateExamQuestionsController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;

import java.util.Map;

public class AddUpdateExamQuestionsUI {

    private final AddUpdateExamQuestionsController theController = new AddUpdateExamQuestionsController();


    protected boolean doShow() {

        Map<Integer, QuestionType> listOfQuestionTypes = theController.getAllQuestionTypes();
        showExistingTypes(listOfQuestionTypes, "Select the question type:");
        int option = Console.readOption(1, listOfQuestionTypes.size(), 0);

        final String question = Console.readNonEmptyLine("Insert the Question: ", "The question cannot be empty!");

        try {
            createQuestions(question, option);
        } catch (final IntegrityViolationException e) {
            System.out.println("You tried to enter a question which already exists in the database.");
        } catch (final ConcurrencyException e) {
            System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return false;
    }


    protected void createQuestions(String question, int option) {
        Question newQuestion;

        switch (option) {
            case 1:
                final String[] matchingOptions = Console.readNonEmptyLine("Insert Matching Options (separate by comma)", "The options cannot be empty!").split(",");
                final String[] matchingAnswers = Console.readNonEmptyLine("Insert Matching Answers (separate by comma)", "The answers cannot be empty!").split(",");
                final String[] matchingSolution = new String[]{Console.readNonEmptyLine("Insert Solution (separate by comma)", "The question needs a solution!")};
                newQuestion = theController.createMatchingQuestion(question, matchingSolution, matchingOptions, matchingAnswers, option);
                break;
            case 2:
                final String[] multipleChoice = Console.readNonEmptyLine("Insert Multiple Choice Options (separate by comma)", "The options cannot be empty!").split(",");
                final int solutionIndex = Console.readInteger("Insert the index of the Correct Option (starting from 1)") - 1;
                newQuestion = theController.createMultipleChoiceQuestion(question, String.valueOf(solutionIndex), multipleChoice, option);
                break;
            case 3:
                final String solution = Console.readNonEmptyLine("Insert Solution", "The question needs a solution!");
                final String isCaseSensitive = Console.readNonEmptyLine("Is it Case Sensitive?\n Type 'yes' or 'no' ", "Case sensitive needs to be defined!");
                newQuestion = theController.createShortAnswerQuestion(question, solution, isCaseSensitive, option);
                break;
            case 4:
                final double acceptanceError = Console.readDouble("Insert Acceptence Error (positive number)");
                final String[] answerOptions = Console.readNonEmptyLine("Insert Answer Options (separate by comma)", "The options cannot be empty!").split(",");
                final String[] solutions = new String[]{Console.readNonEmptyLine("Insert Solutions (separate by comma)", "The question needs a solution!")};
                newQuestion = theController.createNumericalQuestion(question, solutions, answerOptions, acceptanceError, option);
                break;
            case 5:
                final String[] wordsOptions = Console.readNonEmptyLine("Insert Words (separate by comma)", "The words cannot be empty!").split(",");
                final String[] WordSolutions = new String[]{Console.readNonEmptyLine("Insert Solutions (separate by comma)", "The question needs a solution!")};
                newQuestion = theController.createSelectMissingWordsQuestion(question, WordSolutions, wordsOptions, option);
                break;
            case 6:
                final String shortSolution = Console.readNonEmptyLine("Insert Solution", "The question needs a solution!");
                newQuestion = theController.createTrueOrFalseQuestion(question, shortSolution, option);
                break;

        }

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

}
