package eCourse.application;

import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.Student;
import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;

import java.time.LocalDate;

public class CourseEnrollmentRequestService {

    public Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests() {
        return PersistenceContext.repositories().courseEnrollmentRequests().pendingCourseEnrollmentRequests();
    }

    public boolean validateCourseEnrollmentRequest(Student student, Course course) {
        for (CourseEnrollmentRequest enrollment : pendingCourseEnrollmentRequests()) {
            if (enrollment.getCourse().equals(course)  && enrollment.getStudent().equals(student)) {
                return false;
            }
        }
        return true;
    }
}
