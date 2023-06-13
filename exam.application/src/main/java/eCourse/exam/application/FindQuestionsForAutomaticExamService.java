package eCourse.exam.application;

import eCourse.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class FindQuestionsForAutomaticExamService {

    /**
     * This return a list of question of type selected
     * @param listOfQuestions
     * @param numberOfQuestions
     * @return
     */
    public List<Question> listQuestionsForExam(List<Question> listOfQuestions, int numberOfQuestions) {

        List<Question> questionToExam = new ArrayList<>();

        for (int i = 0; i < numberOfQuestions; i++) {

            if(i>= listOfQuestions.size()) {
                questionToExam.add(listOfQuestions.get(i));
            }
        }
        return questionToExam;
    }
}
