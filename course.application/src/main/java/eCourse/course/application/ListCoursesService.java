package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class ListCoursesService {

    public Iterable<Course> allCourses(){

        return PersistenceContext.repositories().courses().findAll();
    }

    public List<Course> getOpenCourses() {
        List<Course> openCourses = new ArrayList<>();
        for (Course course : allCourses()) {
            if (course.getCourseState().getActualState().equals("Open")) {
                openCourses.add(course);
            }
        }
        return openCourses;
    }


}
