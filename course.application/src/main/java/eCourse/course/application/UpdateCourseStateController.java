package eCourse.course.application;

import eCourse.domain.Course;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.util.Optional;

public class UpdateCourseStateController {

    private UpdateCourseStateService updateCourseStateService = new UpdateCourseStateService();
    private ListCoursesService service = new ListCoursesService();

    public Optional<Course> findCourseByDesignation(final String designationName) {
        return this.updateCourseStateService.findCourseByDesignation(designationName);
    }

    public Optional<Course> updateCourseState(String designationName, String newState) throws IntegrityViolationException, ConcurrencyException {
        return this.updateCourseStateService.updateCourseState(designationName, newState);

    }
    public Iterable<Course> allCourses() {

        return service.allCourses();
    }
}