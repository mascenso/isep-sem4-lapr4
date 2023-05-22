package eCourse.course.application;

import eCourse.domain.Course;
import eCourse.domain.CourseStates;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UpdateCourseStateController {

    private UpdateCourseStateService updateCourseStateService = new UpdateCourseStateService();

    //@Autowired
    private ListCoursesService service = new ListCoursesService();


    private final CourseRepository courseRepository;
    private Course course;

    public UpdateCourseStateController() {
        this.courseRepository = PersistenceContext.repositories().courses();
    }

    public Optional<Course> findCourseByDesignation(final String designationName) {
        //Preconditions.nonEmpty(designationName);

        //final Designation designation = Designation.valueOf(designationName);
        return this.updateCourseStateService.findCourseByDesignation(designationName);
    }

    public void updateCourseState(String designationName, String newState) throws IntegrityViolationException, ConcurrencyException {
        Optional<Course> optionalCourse = findCourseByDesignation(designationName);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            switch (newState) {
                case "Open":
                    updateCourseStateService.open(designationName);
                    break;
                case "Close":
                    updateCourseStateService.close(designationName);
                    break;
                case "Enroll":
                    updateCourseStateService.enroll(designationName);
                    break;
                case "Progress":
                    updateCourseStateService.closeEnroll(designationName);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid state: " + newState);
            }

            //PersistenceContext.repositories().courses().save(course);
        } else {
            throw new NoSuchElementException("Course not found: " + designationName);
        }
    }


    public Iterable<Course> allCourses() {

        return service.allCourses();
    }

}





