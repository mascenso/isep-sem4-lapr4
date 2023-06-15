package eCourse.application;

import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;

public class CourseEnrollmentRequestService {

    public Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests() {
        return PersistenceContext.repositories().courseEnrollmentRequests().pendingCourseEnrollmentRequests();
    }

    public boolean validateCourseEnrollmentRequest(Student student, Course course) {
        for (CourseEnrollmentRequest enrollment : pendingCourseEnrollmentRequests()) {
            if (enrollment.courseEnrollmentRequestCourse().equals(course)  && enrollment.courseEnrollmentRequestStudent().equals(student)) {
                return false;
            }
        }
        return true;
    }
}
