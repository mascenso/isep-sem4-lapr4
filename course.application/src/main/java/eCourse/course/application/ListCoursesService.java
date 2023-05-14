package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import org.springframework.stereotype.Component;

@Component
@ApplicationService
public class ListCoursesService {

    public Iterable<Course> allCourses(){

        return PersistenceContext.repositories().courses().findAll();
    }
}
