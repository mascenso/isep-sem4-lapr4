package eCourse.app.student.console.presentation.Exams;

import eCourse.antlr.ExamSpecificationLexer;
import eCourse.antlr.ExamSpecificationParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeExamUI {
    public static float maxGrade = 0;

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("./exam.txt");
        ExamSpecificationLexer examLexer = new ExamSpecificationLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(examLexer);
        ExamSpecificationParser examParser = new ExamSpecificationParser(commonTokenStream);

        ParseTree parseTree = examParser.exam();
        String feedbackType = parseTree.getChild(3).getChild(3).getChild(1).toString();
        String gradeType = parseTree.getChild(3).getChild(4).getChild(1).toString();


        float studentGrade =0;


        //begin exam
        //header
        System.out.println("Let's begin the " + parseTree.getChild(1).toString());
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("This exam has the type of feedback %s and the grade %s.\n", feedbackType,gradeType);
        System.out.println("--------------------------------------------------------------------------------");

        //section
        String sectionName = parseTree.getChild(4).getChild(1).toString();
        System.out.printf("Let's begin the section %s.\n",sectionName);
        System.out.println();
        System.out.println();

        //Questions
        //Get all questions
        List<ParseTree> listOfQuestions = new ArrayList<>();
        for (int i = 5; !parseTree.getChild(4).getChild(i).toString().equalsIgnoreCase("}") ; i++) {
            listOfQuestions.add(parseTree.getChild(4).getChild(i));
        }

        for (int i = 0; i < listOfQuestions.size(); i++) {
            String typeOfQuestion = listOfQuestions.get(i).getChild(0).getChild(0).toString();
            //maxGrade += Integer.parseInt(listOfQuestions.get(i).getChild(0).getChild(6).getChild(0).toString());
            System.out.println();
            studentGrade += makeQuestionForUser(listOfQuestions.get(i));
        }
        System.out.println();
        float finalGrade =studentGrade/maxGrade*100;
        System.out.printf("Finished the exam with the grade %.2f.\nYou've reached %.2f at a maximum of %.2f\n",finalGrade,studentGrade,maxGrade);

    }

    private static float makeQuestionForUser(ParseTree parseTree) {
        switch (parseTree.getChild(0).getChild(0).toString()){
            case"TrueOrFalseQuestion":
                return makeTrueFalseQuestion(parseTree);
            case"ShortAnswerQuestion":
                return makeShortAnswerQuestion(parseTree);
            case "NumericalQuestion":
                return makeNumericalQuestion(parseTree);
            case "matchingQuestion":
                return makeMatchingQuestion(parseTree);
            case "MultipleChoiceQuestion":
                return makeMultipleChoiceQuestion(parseTree);
            case "MissingWordsQuestion":
                return makeMissingWordsQuestion(parseTree);
        }
        return 0;
    }

    private static float makeMissingWordsQuestion(ParseTree parseTree) {
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        List <String> correctAnswer = List.of(parseTree.getChild(0).getChild(5).getChild(0).toString().replace("\"", "").split(" "));
        List <String> options = List.of(parseTree.getChild(0).getChild(3).getChild(1).getChild(1).getChild(0).toString().replace("\"", "").split(" "));
        List <String> answerOfUser =new ArrayList<>();
        List <String> gradesByCorrectAnswer = List.of(parseTree.getChild(0).getChild(9).getChild(0).toString().replace("\"", "").split(" "));
        float grade =0;
        Scanner scanner = new Scanner(System.in);

        //show question and wait for answer
        for (int i = 0; i < correctAnswer.size(); i++) {
            System.out.printf("\nQuestion: %s\n\n",question);
            for (int j = 0; j < options.size(); j++) {
                System.out.printf("Option: %s\n",options.get(j));
            }
            System.out.printf("\nWhat is the word for %d space?\n",i+1);
            System.out.print("Answer: ");
            answerOfUser.add(scanner.nextLine());
            System.out.println();
        }

        //calculate the grade of user and max grade of exam
        for (int i = 0; i < correctAnswer.size(); i++) {
            if(correctAnswer.get(i).equalsIgnoreCase(answerOfUser.get(i))){
                grade += Float.parseFloat(gradesByCorrectAnswer.get(i));
            }
            maxGrade += Float.parseFloat(gradesByCorrectAnswer.get(i));
        }

        return grade;
    }

    private static float makeMultipleChoiceQuestion(ParseTree parseTree) {
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        List <String> correctAnswer = new ArrayList<>();
        List <String> gradeForAnyAnswer = new ArrayList<>();
        List<String> answerOfUser =new ArrayList<>();
        float grade =0;
        Scanner scanner = new Scanner(System.in);

        //get all answers
        for (int i = 0; i < parseTree.getChild(0).getChildCount(); i++) {
            if(parseTree.getChild(0).getChild(i).toString().contains("Answer")){
                correctAnswer = List.of(parseTree.getChild(0).getChild(i + 1).getChild(0).toString().replace("\"", "").split(" "));
            }
            if(parseTree.getChild(0).getChild(i).toString().contains("Grade")){
                gradeForAnyAnswer = List.of(parseTree.getChild(0).getChild(i + 1).getChild(0).toString().replace("\"", "").split(" "));
            }
        }


        System.out.printf("Question: %s\n",question);

        //show options
        for (int i = 3; !parseTree.getChild(0).getChild(i).toString().contains("Answer"); i++) {
            System.out.printf("Option: %s\n",parseTree.getChild(0).getChild(i).getChild(1).toString().replace("\"", "").split(" "));
        }

        //user response
        System.out.println();
        System.out.println("If you want choose more than one options please separates with a blank space.");
        System.out.println("Select option by same order.");
        System.out.print("Answer: ");
        String userAnswer = scanner.nextLine();
        answerOfUser = List.of(userAnswer.split(" "));

        //validate answers , calculate grade of user and max grade of exam
        for (int i = 0; i < correctAnswer.size(); i++) {
            if(i<answerOfUser.size() && correctAnswer.get(i).equalsIgnoreCase(answerOfUser.get(i))){
                grade += Float.parseFloat(gradeForAnyAnswer.get(i).toString());
            }
            maxGrade += Float.parseFloat(gradeForAnyAnswer.get(i).toString());
        }
        return grade;
    }

    private static float makeMatchingQuestion(ParseTree parseTree) {
        System.out.println();
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        List <String> ListOne = List.of(parseTree.getChild(0).getChild(3).getChild(1).getChild(0).toString().replace("\"", "").split(" "));
        List <String> ListForMatching = List.of(parseTree.getChild(0).getChild(4).getChild(1).getChild(0).toString().replace("\"", "").split(" "));
        List <String> correctAnswer = List.of(parseTree.getChild(0).getChild(6).getChild(0).toString().replace("\"", "").split(" "));
        List <String> answerOfUser = new ArrayList<>();
        float grade =0;
        Scanner scanner = new Scanner(System.in);

        //show 2 lists side by side
        System.out.printf("%-20s%-20s\n","List","List for matching");
        System.out.println("----------------------------------------");
        for (int i = 0; i < ListForMatching.size() || i< ListOne.size(); i++) {
            if(i< ListForMatching.size() && i< ListOne.size()){
                System.out.printf("%-20s%-20s\n",ListOne.get(i),ListForMatching.get(i));
            }else if(i< ListForMatching.size()){
                System.out.printf("%-20s%-20s\n","",ListForMatching.get(i));
            }else{
                System.out.printf("%-20s%-20s\n",ListOne.get(i),"");
            }
        }
        //make questions to the user
        for (int i = 0; i < ListOne.size(); i++) {
            System.out.printf("Which one does it match with %s?\n",ListOne.get(i));
            System.out.print("Answer: ");
            answerOfUser.add(scanner.nextLine());
        }

        //validate answers, calculate grade of student and max grade of exam
        for (int i = 0; i < answerOfUser.size(); i++) {
            if(answerOfUser.get(i).equalsIgnoreCase(correctAnswer.get(i))){
                grade += Float.parseFloat(parseTree.getChild(0).getChild(8).getChild(0).toString());
            }
            maxGrade += Float.parseFloat(parseTree.getChild(0).getChild(8).getChild(0).toString());
        }
        return grade;
    }

    private static float makeNumericalQuestion(ParseTree parseTree) {
        System.out.println();
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        float correctAnswer = 0;
        float aceptError = Float.parseFloat(parseTree.getChild(0).getChild(3).getChild(1).toString());
        List <String> options = new ArrayList<>();
        float answerOfUser =0;
        float correctGrade = 0;
        float grade =0;
        Scanner scanner = new Scanner(System.in);

        //get correct Answer and correct grade
        for (int i = 0; i < parseTree.getChild(0).getChildCount(); i++) {
            if(parseTree.getChild(0).getChild(i).toString().contains("Answer")){
                correctAnswer = Float.parseFloat(parseTree.getChild(0).getChild(i+1).getChild(0).toString());
            }
            if (parseTree.getChild(0).getChild(i).toString().contains("Grade")){
                correctGrade = Float.parseFloat(parseTree.getChild(0).getChild(i+1).getChild(0).toString());
                maxGrade += correctGrade;
            }
        }

        //get options
        for (int i = 4; parseTree.getChild(0).getChild(i).toString().contains("Answer"); i++) {
            options.add(parseTree.getChild(0).getChild(i).getChild(1).toString());
        }

        System.out.printf("Question: %s (use , if number is decimal)\n",question);

        //show options
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("Option: %s\n",options.get(i));
        }

        System.out.print("Answer: ");
        answerOfUser = scanner.nextFloat();

        //validate answer of user
        if(Math.abs(answerOfUser - correctAnswer) <= aceptError){
            grade = correctGrade;
        }

        return grade;
    }

    private static float makeShortAnswerQuestion(ParseTree parseTree) {
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        List <String> correctAnswer = new ArrayList<>();
        List <String> gradesByAnswer = new ArrayList<>();
        List <String> options = new ArrayList<>();
        float grade =0;
        Scanner scanner = new Scanner(System.in);
        String answerOfUser ="";

        //get correct option
        for (int i = 0; i < parseTree.getChild(0).getChildCount(); i++) {
            if(parseTree.getChild(0).getChild(i).toString().contains("Answer")){
                correctAnswer = List.of(parseTree.getChild(0).getChild(i + 1).getChild(0).toString().split(" "));
            }
        }
        //get all options
        for (int i = 3; !parseTree.getChild(0).getChild(i).toString().contains("Sensitive"); i++) {
                String option = parseTree.getChild(0).getChild(i).getChild(1).toString();
                options.add(option);
        }

        //get list of grades
        int count=0;
        for (int i = parseTree.getChild(0).getChildCount()-correctAnswer.size()-1; count < correctAnswer.size(); i++) {
            String gradeTemp = parseTree.getChild(0).getChild(i).getChild(0).toString();
            gradesByAnswer.add(gradeTemp);
            count++;
        }
        System.out.printf("Question: %s\n",question);

        //show options
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("Option: %s\n",options.get(i));
        }

        System.out.print("Answer: ");
        answerOfUser = scanner.nextLine();

        //validate if is a correct answer
        for (int i = 0; i < correctAnswer.size(); i++) {
            if(answerOfUser.equalsIgnoreCase(correctAnswer.get(i))){
                grade = Float.parseFloat(gradesByAnswer.get(i));
            }
        }
        //the first is the big grade and only one is right
        maxGrade += Float.parseFloat(gradesByAnswer.get(0));
        return grade;
    }

    private static float makeTrueFalseQuestion(ParseTree parseTree) {
        String question = parseTree.getChild(0).getChild(1).getChild(0).toString();
        String correctAnswer = parseTree.getChild(0).getChild(4).toString();
        String answerOfUser ="";
        float grade =0;
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Question: %s\n",question);

        do{
            System.out.println("Options: True or False\n");
            System.out.print("Answer: ");
            answerOfUser = scanner.nextLine();
        }while (!answerOfUser.equalsIgnoreCase("true") && !answerOfUser.equalsIgnoreCase("false"));

        //validate the grade of user
        if(answerOfUser.equalsIgnoreCase(correctAnswer)){
            grade = Float.parseFloat(parseTree.getChild(0).getChild(6).getChild(0).toString());
        }
        //get the max grade of exam
        maxGrade += Float.parseFloat(parseTree.getChild(0).getChild(6).getChild(0).toString());
        return grade;
    }

}
