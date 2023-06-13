package eCourse.question.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.QuestionRepository;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

@UseCaseController
@Component
public class UpdateExamQuestionsController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    @Autowired
    private UpdateExamQuestionService examQuestionService = new UpdateExamQuestionService();


    public List<Course> getOpenCourses() {
        return courseService.getOpenCourses();
    }


    public Map<Integer, QuestionType> getAllQuestionTypes() {
        return QuestionType.getListOfQuestionTypes();
    }

    public QuestionType getQuestionType(int option) {
        return QuestionType.getQuestionType(option);
    }

    public List<Question> getQuestionByTypeAndCourse(QuestionType selectedQuestionType, Course selectedCourse) {
        return examQuestionService.getQuestionByTypeAndCourse(selectedQuestionType, selectedCourse);
    }

    @Transactional
    public Question updateQuestion(Question question, File file, QuestionType questionType, Course course) {
        question.updateQuestion(file, questionType, course);
        return PersistenceContext.repositories().questions().save(question);
    }
}

