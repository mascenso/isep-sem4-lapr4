package eCourse.course.application;

import eCourse.domain.Course;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListCoursesTeacherController {

    @Autowired
    private ListCoursesService service = new ListCoursesService();

    public Iterable<Course> allCoursesOpen() {

        return service.getOpenCourses();
    }

}
