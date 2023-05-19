package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.usermanagement.domain.BaseCourseStates;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;

import java.util.NoSuchElementException;

public class UpdateCourseStateService {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courses();

    public void open(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to OPEN if it comes from the CLOSE state
        if (!course.state().equals(BaseCourseStates.CLOSE)){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + "which cannot transition to " + BaseCourseStates.OPEN);
        }

        //3 - update the course with the state OPEN
        course.updateState(BaseCourseStates.OPEN);
        courseRepository.save(course);
    }

    public void close(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to CLOSE if it comes from the PROGRESS state
        if (!course.state().equals(BaseCourseStates.PROGRESS)){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + "which cannot transition to " + BaseCourseStates.CLOSE);
        }

        //3 - update the course with the state CLOSE
        course.updateState(BaseCourseStates.CLOSE);
        courseRepository.save(course);
    }



}
