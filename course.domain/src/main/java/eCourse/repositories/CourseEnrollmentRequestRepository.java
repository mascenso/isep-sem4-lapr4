package eCourse.repositories;

import eCourse.domain.CourseEnrollmentRequest;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface CourseEnrollmentRequestRepository extends DomainRepository<Username, CourseEnrollmentRequest> {

    Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests();

}
