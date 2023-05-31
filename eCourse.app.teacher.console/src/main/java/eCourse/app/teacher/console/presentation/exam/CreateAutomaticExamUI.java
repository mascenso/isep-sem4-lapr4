package eCourse.app.teacher.console.presentation.exam;

import eCourse.domain.QuestionType;
import eCourse.exam.application.CreateAutomaticExameController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Map;

public class CreateAutomaticExamUI extends AbstractUI {

    CreateAutomaticExameController theController = new CreateAutomaticExameController();
    @Override
    protected boolean doShow() {

        final String title = Console.readNonEmptyLine("Insert the Exam title:", "The title cannot be empty!");

        Map<Integer, QuestionType> questionsType = theController.listQuestionType();
        int typeOfQuestion = 0;

        do {
            for (int i = 0; i < questionsType.size(); i++) {
                System.out.printf("(%d) %s\n",i+1,questionsType.get(i+1));
            }

            typeOfQuestion = Console.readInteger("Insert tipe of question.");
            if (typeOfQuestion<1 || typeOfQuestion>questionsType.size()){
                System.out.println("===========================");
                System.out.println("Please insert valid option!");
                System.out.println("===========================");
            }
        }while (typeOfQuestion<1 || typeOfQuestion>questionsType.size());

        final int numberOfQuestions = Console.readInteger("Insert number of questions.");

        //create a automatic exame with title, type of question and quantity
        //theController.CreateAutomaticExame(title,questionsType.get(typeOfQuestion),numberOfQuestions);
        return false;
    }

    @Override
    public String headline() {
        return "Automatic Exam";
    }
}
