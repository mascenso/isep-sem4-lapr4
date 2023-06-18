package eCourse.exam.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eapli.framework.application.UseCaseController;
import org.springframework.stereotype.Component;



@UseCaseController
@Component
public class ListExamsCourseController {

    private final ListCoursesService courseService = new ListCoursesService();
    private final ListExamsService examService = new ListExamsService();

    public Iterable<Course> allCoursesInProgress() {
        return courseService.inProgressCourses();
    }

    public Iterable<Exam> listExamsByCourse(Course course) {
        return examService.getExamByCourse(course);
    }
}
