package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.domain.CourseStates;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.usermanagement.domain.BaseCourseStates;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import java.util.Optional;

public class UpdateCourseStateController {

    private UpdateCourseStateService courseStateService = new UpdateCourseStateService();

    public UpdateCourseStateController(){

    }

    public Optional<Course> findCourseByDesignation(final String designationName){
        return this.courseStateService.findCourseByDesignation(designationName);
    }

    public void updateCourseState(String designationName, String newState) throws IntegrityViolationException, ConcurrencyException{
        if (CourseState.valueOf(newState).equals(BaseCourseStates.OPEN)){
            this.courseStateService.open(designationName);
            return;

        }

        if (CourseState.valueOf(newState).equals(BaseCourseStates.CLOSE)){
            this.courseStateService.close(designationName);
            return;

        }
    }

    /*
    private UpdateCourseStateService updateCourseStateService = new UpdateCourseStateService();

    private final CourseRepository courseRepository;
    private Course course;

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
        //CourseBuilder courseBuilder = new CourseBuilder();
        //Course updateState = courseBuilder.state(CourseState.valueOf(newState)).build();
        optionalCourse.get().updateState(CourseState.valueOf(newState));
        PersistenceContext.repositories().courses().save(optionalCourse.get());
        //PersistenceContext.repositories().courses().save(updateState);

    }

     */

}





