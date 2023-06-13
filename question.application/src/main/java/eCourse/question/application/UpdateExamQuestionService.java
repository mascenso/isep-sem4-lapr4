package eCourse.question.application;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.QuestionRepository;
import eapli.framework.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class UpdateExamQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Iterable<Question> allQuestions() {
        return PersistenceContext.repositories().questions().findAll();
    }

    public List<Question> getQuestionByTypeAndCourse(QuestionType selectedQuestionType, Course selectedCourse) {
        List<Question> listOfQuestionsByCourse = new ArrayList<>();
        for (Question qt : allQuestions()) {
            if (qt.getQuestionType().equals(selectedQuestionType) && qt.getQuestionCourse().equals(selectedCourse)) {
                listOfQuestionsByCourse.add(qt);
            }
        }
        return listOfQuestionsByCourse;
    }


}
