package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.general.domain.model.Designation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@ApplicationService
public class ListCoursesService {

    public Iterable<Course> allCourses(){
        return PersistenceContext.repositories().courses().findAll();
    }

    public Optional<Course> findCourseByDesignation(final Designation designationName) {
        return PersistenceContext.repositories().courses().findByDesignation(designationName);
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

    public List<Course> getEnrollmentCourses() {
        List<Course> enrollCourses = new ArrayList<>();
        for (Course course : allCourses()) {
            if (course.getCourseState().getActualState().equals("Enroll")) {
                enrollCourses.add(course);
            }
        }
        return enrollCourses;
    }


}
