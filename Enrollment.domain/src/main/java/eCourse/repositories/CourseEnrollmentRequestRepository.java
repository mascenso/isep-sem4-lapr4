package eCourse.repositories;

import eCourse.domain.CourseEnrollmentRequest;
import eapli.framework.domain.repositories.DomainRepository;


public interface CourseEnrollmentRequestRepository extends DomainRepository<Long, CourseEnrollmentRequest> {

    Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests();
}
