package eCourse.course.application;

import eCourse.domain.BaseCourseStates;
import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;

import eCourse.domain.ECourseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UpdateCourseStateService {
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courses();

    public Optional<Course> findCourseByDesignation(final String designationName) {
        Preconditions.nonEmpty(designationName);

        final Designation designation = Designation.valueOf(designationName);
        return courseRepository.findByDesignation(designation);
    }

    public Optional<Course> updateCourseState(String designationName, String newState) throws IntegrityViolationException, ConcurrencyException {
        Optional<Course> optionalCourse = findCourseByDesignation(designationName);

        if (optionalCourse.isPresent()) {
            switch (newState) {
                case "Open":
                    open(designationName);
                    break;
                case "Close":
                    close(designationName);
                    break;
                case "Enroll":
                    enroll(designationName);
                    break;
                case "Progress":
                    closeEnroll(designationName);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid state: " + newState);
            }

            //PersistenceContext.repositories().courses().save(course);
        } else {
            throw new NoSuchElementException("Course not found: " + designationName);
        }
        return optionalCourse;
    }

    public void open(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        //authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER);
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.ADMIN, ECourseRoles.MANAGER,ECourseRoles.POWER_USER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to OPEN if it comes from the CLOSE state
        if (!String.valueOf(course.state()).equals(String.valueOf(BaseCourseStates.CLOSE))){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + " which cannot transition to " + BaseCourseStates.OPEN);
        }

        //3 - update the course with the state OPEN
        course.open();
        courseRepository.save(course);
    }

    public void enroll(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.ADMIN, ECourseRoles.MANAGER,ECourseRoles.POWER_USER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to ENROLL if it comes from the OPEN state
        if (!String.valueOf(course.state()).equals(String.valueOf(BaseCourseStates.OPEN))){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + " which cannot transition to " + BaseCourseStates.ENROLL);
        }

        //3 - update the course with the state ENROLL
        course.enroll();
        courseRepository.save(course);
    }

    public void closeEnroll(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.ADMIN, ECourseRoles.MANAGER,ECourseRoles.POWER_USER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to PROGRESS if it comes from the ENROLL state
        if (!String.valueOf(course.state()).equals(String.valueOf(BaseCourseStates.ENROLL))){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + " which cannot transition to " + BaseCourseStates.PROGRESS);
        }

        //3 - update the course with the state OPEN
        course.progress();
        courseRepository.save(course);
    }

    public void close(String designationName) {
        //1 - validate if the user is authenticated and has a valid role
        //authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER);
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.ADMIN, ECourseRoles.MANAGER, ECourseRoles.POWER_USER);

        //2 - validate params
        Preconditions.nonEmpty(designationName); //the name of the course cannot be empty

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(designationName))
                .orElseThrow(() -> new NoSuchElementException("The course " + designationName + " does not exist in the database"));

        //the course can only transition to CLOSE if it comes from the PROGRESS state
        if (!String.valueOf(course.state()).equals(String.valueOf(BaseCourseStates.PROGRESS))){
            throw new IllegalArgumentException("The course " + designationName + " has the state " + course.state()
                    + " which cannot transition to " + BaseCourseStates.CLOSE);
        }

        //3 - update the course with the state CLOSE
        course.close();
        courseRepository.save(course);
    }



}
