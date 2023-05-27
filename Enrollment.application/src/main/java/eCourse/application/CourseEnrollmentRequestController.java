package eCourse.application;

import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.CourseEnrollmentRequestBuilder;
import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class CourseEnrollmentRequestController {

    public CourseEnrollmentRequest courseEnrollment(Course course, Student student) {

        final var newCourseEnrollment = new CourseEnrollmentRequestBuilder().theCourse(course).
                theStudent(student);

        return PersistenceContext.repositories().courseEnrollmentRequests().save(newCourseEnrollment);
    }

}
