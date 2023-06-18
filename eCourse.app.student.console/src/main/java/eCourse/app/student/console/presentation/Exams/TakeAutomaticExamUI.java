package eCourse.app.student.console.presentation.Exams;

import eCourse.antlrExam.ExamSpecificationLexer;
import eCourse.antlrExam.ExamSpecificationParser;
import eCourse.domain.AutomaticExame;
import eCourse.exam.application.TakeAutomaticExameController;
import eapli.framework.presentation.console.AbstractUI;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.*;

public class TakeAutomaticExamUI extends AbstractUI {

    static TakeAutomaticExameController theController = new TakeAutomaticExameController();
        @Override
        protected boolean doShow() {

            List<AutomaticExame> ListOfExams = theController.AutomaticExamsUnsolved();
            AutomaticExame examSelected = showListExams(ListOfExams);
            Map<String,Float> feedback = new LinkedHashMap<>();

            CharStream charStream = null;
            try {
                charStream = CharStreams.fromFileName("./"+examSelected.getExamFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ExamSpecificationLexer examLexer = new ExamSpecificationLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(examLexer);
            ExamSpecificationParser examParser = new ExamSpecificationParser(commonTokenStream);
            ParseTree parseTree = examParser.exam();

            Map<String, Map<String, Object>> exam = theController.buildExameForTaken(parseTree);
            Map<String, Object> header = exam.get("Header");

            //max grade for exam
            final float maxExamGrade = Float.parseFloat(header.get("MaxExamGrade").toString());
            float studentGrade = 0;
            //begin exam
            //header
            System.out.printf("Let's begin the %s\n", header.get("examTitle"));
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("This exam has the %s and the %s.\n", header.get("feedbackType"), header.get("gradeType"));
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("\nLet's begin the section %s.\n", header.get("sectionTitle"));

            //show questions
            for (Map.Entry<String, Map<String, Object>> entry : exam.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase("Header")) {
                    studentGrade += makeQuestionForUser(entry,feedback);
                    System.out.println(studentGrade);
                }

            }

            //show feedback
            if(!feedback.isEmpty()){
                System.out.println();
                System.out.printf("%-10s%-40s%-20s\n", "Number", "Question", "Grade");
                int index =1;
                for (Map.Entry<String, Float> entry : feedback.entrySet()) {
                    String key = entry.getKey();
                    Float value = entry.getValue();
                    System.out.printf("%-10s%-40s%-20s\n", index, key, value);
                    index++;
                }
                System.out.println();
            }

            //show grades
            System.out.printf("You got %.0f%% of exam right.\n", theController.getExamGradeOnPercentage(studentGrade, maxExamGrade));
            System.out.printf("You had %.2f of %.2f possible points.\n", studentGrade, maxExamGrade);

            theController.saveGrade(theController.getExamGradeOnPercentage(studentGrade, maxExamGrade),examSelected);
        return true;
    }

    private AutomaticExame showListExams(List<AutomaticExame> listOfExams) {
            if(listOfExams.isEmpty()){
                System.out.println("=========================");
                System.out.println("Dont exist exams to take.");
                System.out.println("=========================");
                return null;
            }else{
            Scanner scanner = new Scanner(System.in);
            int selectedOption = -1;
            do {
                for (int i = 0; i < listOfExams.size(); i++) {
                    System.out.printf("(%d) %s\n", i, listOfExams.get(i).getExamTitle());
                }
                selectedOption = scanner.nextInt();
                if (selectedOption<0 || selectedOption >= listOfExams.size()){
                    System.out.println("Select a valid exam.");
                }
            }while (selectedOption<0 || selectedOption >= listOfExams.size());
            return listOfExams.get(selectedOption);}
    }

    @Override
    public String headline() {
        return "Take a exam";
    }

    private static float makeQuestionForUser(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        if(question.getKey().contains("TrueOrFalseQuestion")){
            return makeTrueFalseQuestion(question,feedback);
        }
        if(question.getKey().contains("ShortAnswerQuestion")){
            return makeShortAnswerQuestion(question,feedback);
        }
        if(question.getKey().contains("NumericalQuestion")){
            return makeNumericalQuestion(question,feedback);
        }
        if(question.getKey().contains("matchingQuestion")){
            return makeMatchingQuestion(question,feedback);
        }
        if(question.getKey().contains("MultipleChoiceQuestion")){
            return makeMultipleChoiceQuestion(question,feedback);
        }
        if(question.getKey().contains("MissingWordsQuestion")){
            return makeMissingWordQuestion(question,feedback);
        }

        return 0;
    }

    private static float makeMissingWordQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        List <String> userAnswer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfAttemps = (int)question.getValue().get("numberOfAtemps");
        List <String> options = (List<String>) question.getValue().get("options");
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("This is a question of Missing Word.\nIf you choose more than one option, separate them by a space.");
        System.out.printf("\nQuestion: %s\n",question.getValue().get("Question").toString());

        do{
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("Option: %s\n",options.get(i));
            }

            System.out.print("Answer: ");
            userAnswer = List.of(scanner.nextLine().split(" "));
            numberOfAttemps--;
            if(numberOfAttemps>0 && theController.validateMissingWordQuestion(userAnswer,question) < (float)question.getValue().get("MaxGrade")){
                System.out.println("You have "+ numberOfAttemps + " more attempts.");
            }
        }
        while (numberOfAttemps!=0 && theController.validateMissingWordQuestion(userAnswer,question)< (float)question.getValue().get("MaxGrade"));

        //build feedback
        feedback.put("Missing Word",theController.validateMissingWordQuestion(userAnswer,question));

        return theController.validateMissingWordQuestion(userAnswer,question);
    }

    private static float makeMultipleChoiceQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        List <String> userAnswer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<String> options = (List<String>)question.getValue().get("options");
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("This is a question of Multiple choice. \nIf you choose more than one option, separate them by a space.");
        System.out.printf("\nQuestion: %s\n",question.getValue().get("Question").toString());

        for (int i = 0; i < options.size(); i++) {
            System.out.printf("Option: %s\n",options.get(i));
        }
        System.out.print("Answer: ");
        userAnswer = List.of(scanner.nextLine().split(" "));

        //build feedback
        feedback.put(question.getValue().get("Question").toString(),theController.validateMultipleChoiceQuestion(userAnswer,question));

        return theController.validateMultipleChoiceQuestion(userAnswer,question);
    }

    private static float makeMatchingQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        List<String> userAnswer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<String> ListOne = (List<String>) question.getValue().get("ListOne");
        List<String> ListForMatching = (List<String>) question.getValue().get("ListTwo");

        //show 2 lists side by side
        System.out.println("\n--------------------------------------------------------------------------");
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
            userAnswer.add(scanner.nextLine());
        }

        //build feedback
        feedback.put("Matching question",theController.validateMatchingQuestion(userAnswer,question));

        return theController.validateMatchingQuestion(userAnswer,question);
    }

    private static float makeNumericalQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        float userAnswer =0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\nThis is a question of Numerical Answer.\nUse '.' and not ','");
        System.out.printf("\nQuestion: %s\n",question.getValue().get("Question").toString());
        System.out.print("Answer: ");
        userAnswer = scanner.nextFloat();

        //build feedback
        feedback.put(question.getValue().get("Question").toString(),theController.validateNumericalQuestion(userAnswer,question));

        return theController.validateNumericalQuestion(userAnswer,question);
    }

    private static float makeShortAnswerQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        String userAnswer = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("This is a question of Short Answer.");
        System.out.printf("\nQuestion: %s\n",question.getValue().get("Question").toString());
        System.out.print("Answer: ");
        userAnswer = scanner.nextLine();

        //build feedback
        feedback.put(question.getValue().get("Question").toString(),theController.validateTheShortAnswer(userAnswer,question));

        return theController.validateTheShortAnswer(userAnswer,question);
    }

    private static float makeTrueFalseQuestion(Map.Entry<String, Map<String, Object>> question, Map<String, Float> feedback) {
        String userAnswer = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("This is a question of True or false.");
        do {
        System.out.printf("\nQuestion: %s\n",question.getValue().get("Question").toString());
        System.out.print("Answer: ");
            userAnswer = scanner.nextLine();
        }while(!theController.isAValidTrueOrFalseAnswer(userAnswer));

        //build feedback
        feedback.put(question.getValue().get("Question").toString(),theController.validateTheAnswerTrueOrFalse(userAnswer,question));

        return theController.validateTheAnswerTrueOrFalse(userAnswer,question);
    }
}
