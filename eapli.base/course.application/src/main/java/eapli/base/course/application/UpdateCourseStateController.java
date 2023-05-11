package eapli.base.course.application;

import eapli.base.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CourseRepository;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import java.util.Optional;

public class UpdateCourseStateController {
    private final CourseRepository courseRepository;

    public UpdateCourseStateController() {
        this.courseRepository = PersistenceContext.repositories().courses();
    }

    public Optional<Course> findCourseByDesignation(final String designationName) {
        Preconditions.nonEmpty(designationName);

        final Designation designation = Designation.valueOf(designationName);
        return courseRepository.findByDesignation(designation);
    }

    public void updateCourseState(String designationName, String newState) throws IntegrityViolationException, ConcurrencyException {
        Optional<Course> optionalCourse = findCourseByDesignation(designationName);
        CourseBuilder courseBuilder = new CourseBuilder();
        Course updateState = courseBuilder.state(CourseStates.valueOf(newState)).build();
        PersistenceContext.repositories().courses().save(updateState);

    }

}





