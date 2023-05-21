package eCourse.question.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.*;
import eCourse.repositories.QuestionRepository;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@UseCaseController
@Component
public class AddExamQuestionsController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    public Question createQuestion(File questionFile, int option, Course selectedCourse, String description) {
        QuestionType qt=QuestionType.getQuestionType(option);

        final Question newQuestion = new QuestionBuilder().theQuestionType(qt).theFile(questionFile).theCourse(selectedCourse).theDescription(description).build();
        
        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    public List<Course> getOpenCourses() {
        return courseService.getOpenCourses();
    }


    public Map<Integer, QuestionType> getAllQuestionTypes() {
        return QuestionType.getListOfQuestionTypes();
    }

    public QuestionType getQuestionType(int option) {
        return QuestionType.getQuestionType(option);
    }
}

