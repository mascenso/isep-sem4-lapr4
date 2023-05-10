package eapli.base.app.backoffice.console.presentation.exam;


import eapli.base.domain.Question;
import eapli.base.domain.Solution;
import eapli.base.exam.application.CreateUpdateExamController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class CreateUpdateExamUI extends AbstractUI {

    private final CreateUpdateExamController theController = new CreateUpdateExamController();


    protected boolean doShow() {
        final Integer numberOfSections = Integer.valueOf(Console.readNonEmptyLine("Number of Sections", "The number of sections should not be empty!"));
        for (int i = 0; i < numberOfSections; i++) {
            final String SecDescription = Console.readLine("Insert section description (optional):");
            final Integer numberOfQuestions = Integer.valueOf(Console.readNonEmptyLine("Number of Questions", "The number of questions should not be empty!"));
            List<Question> questions = new ArrayList<>();

            for (int j = 0; j < numberOfQuestions; j++) {

                System.out.println("Select a question type:");
                System.out.println("1. Matching");
                System.out.println("2. Multiple Choice");
                System.out.println("3. Short Answer");
                System.out.println("4. Numerical");
                System.out.println("5. Select Missing Words");
                System.out.println("6. True or False");
                System.out.println("0. Exit");

                final int option = Console.readOption(1, 6, 0);

                final String question = Console.readNonEmptyLine("Question", "The question cannot be empty!");

                Question newQuestion;
                switch (option) {
                    case 1:
                        final String[] matchingOptions = Console.readNonEmptyLine("Matching Options (separate by comma)", "The options cannot be empty!").split(",");
                        final String[] matchingAnswers = Console.readNonEmptyLine("Matching Answers (separate by comma)", "The answers cannot be empty!").split(",");
                        final String[] matchingSolution = new String[]{Console.readNonEmptyLine("Solution (separate by comma)", "The question needs a solution!")};
                        newQuestion = theController.createMatchingQuestion(question, matchingSolution, matchingOptions, matchingAnswers, option);
                        break;
                    case 2:
                        final String[] multipleChoice = Console.readNonEmptyLine("Multiple Choice Options (separate by comma)", "The options cannot be empty!").split(",");
                        final int solutionIndex = Console.readInteger("Insert the index of the Correct Option (starting from 1)") - 1;
                        newQuestion = theController.createMultipleChoiceQuestion(question, String.valueOf(solutionIndex), multipleChoice, option);
                        break;
                    case 3:
                        final String solution = Console.readNonEmptyLine("Solution", "The question needs a solution!");
                        newQuestion = theController.createShortAnswerQuestion(question, solution, option);
                        break;
                    case 4:
                        final double acceptanceError = Console.readDouble("Acceptence Error (positive number)");
                        final String[] answerOptions = Console.readNonEmptyLine("Answer Options (separate by comma)", "The options cannot be empty!").split(",");
                        final String[] solutions = new String[]{Console.readNonEmptyLine("Solutions (separate by comma)", "The question needs a solution!")};
                        newQuestion = theController.createNumericalQuestion(question, solutions, answerOptions, acceptanceError, option);
                        break;
                    case 5:
                        final String[] wordsOptions = Console.readNonEmptyLine("Words (separate by comma)", "The words cannot be empty!").split(",");
                        final String[] WordSolutions = new String[]{Console.readNonEmptyLine("Solutions (separate by comma)", "The question needs a solution!")};
                        newQuestion = theController.createSelectMissingWordsQuestion(question, WordSolutions, wordsOptions, option);
                        break;
                    case 6:
                        final String shortSolution = Console.readNonEmptyLine("Solution", "The question needs a solution!");
                        newQuestion = theController.createTrueOrFalseQuestion(question, shortSolution, option);
                        break;
                    default:
                        return false;
                }

                questions.add(newQuestion);

            }

            theController.createSections(i, SecDescription, questions);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create/Update Exam";

    }
}