package eCourse.course.application;

import eCourse.domain.Course;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListCoursesController {

    @Autowired
    private ListCoursesService service = new ListCoursesService();

    public Iterable<Course> allCourses() {

        return service.allCourses();
    }

}
