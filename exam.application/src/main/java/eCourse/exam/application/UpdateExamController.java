package eCourse.exam.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamBuilder;
import eCourse.domain.ExamTitle;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@UseCaseController
@Component
public class UpdateExamController {

    @Autowired
    private ListCoursesService courseService = new ListCoursesService();


    @Autowired
    private UpdateExamService examService = new UpdateExamService();


    public List<Course> getOpenCourses() {
        return courseService.getOpenCourses();
    }

    public List<Exam> getExamsByCourse(Course course) {
        return examService.getExamByCourse(course);
    }
    public Exam getExamByTitle(ExamTitle title) {
        return examService.getExamByTitle(title);
    }

    /*
    public Exam getExamByTitle(String title) {
        return examService.getExamByTitle(title);
    }

     */

    public Date getExamOpenDate(Exam exam) {
        return exam.getExamOpenDate();
    }

    public Date getExamCloseDate(Exam exam) {
        return exam.getExamCloseDate();
    }

    @Transactional
    public Exam updateExam( Exam exam, Date newOpenDate, Date newCloseDate, File examFile) {

            exam.updateExam(exam,newOpenDate,newCloseDate,examFile);

        return PersistenceContext.repositories().exams().save(exam);
    }
}
