package eCourse.repositories;

import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;


public interface CourseEnrollmentRequestRepository extends DomainRepository<Long, CourseEnrollmentRequest> {

    Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests();

    CourseEnrollmentRequest findByStudentAndCourse(Student student, Course course);

}
