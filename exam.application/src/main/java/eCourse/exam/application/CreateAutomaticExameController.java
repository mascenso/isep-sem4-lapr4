package eCourse.exam.application;

import eCourse.domain.AutomaticExame;
import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eCourse.infrastructure.persistence.PersistenceContext;

import java.util.List;
import java.util.Map;

public class CreateAutomaticExameController {

    FindQuestionsForAutomaticExamService service = new FindQuestionsForAutomaticExamService();

    /**
     * This function show all the questions types.
     * @return
     */
    public Map<Integer, QuestionType> listQuestionType () {
        return QuestionType.getListOfQuestionTypes();
    }

/*
    public void CreateAutomaticExame(String title, QuestionType questionType, int numberOfQuestions) {
        //FIXME
        throw new UnsupportedOperationException("Not supported yet.");
        //List<Question> listOfQuestions = PersistenceContext.repositories().questions().findByQuestionType(questionType);
        //List<Question> questionsForAutomaticExam = service.listQuestionsForExam(listOfQuestions,numberOfQuestions);
        //AutomaticExame automaticExam = new AutomaticExame(title,questionsForAutomaticExam);
    }

 */
}
