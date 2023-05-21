package eCourse.exam.application;

import eCourse.domain.*;
import eCourse.course.application.ListCoursesService;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.repositories.ExamRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@UseCaseController
@Component
public class CreateExamController {
    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Transactional
    public Exam createExam(final Course course, final String title, Date openDate, Date endDate, final File file) {

        ExamTitle examTitle=ExamTitle.valueOf(title);
        final Exam newExam = new ExamBuilder().theCourse(course).theExamTitle(examTitle).theOpenDate(openDate)
                .theCloseDate(endDate).theFile(file).build();
        return PersistenceContext.repositories().exams().save(newExam);
    }

    public List<Course> getOpenCourses() {
        return courseService.getOpenCourses();
    }

    public ExamTitle getExamTitle(String title) {
        return ExamTitle.valueOf(title);
    }
}
