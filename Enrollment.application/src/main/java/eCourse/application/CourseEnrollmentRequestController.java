package eCourse.application;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.StudentRepository;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

@UseCaseController
public class CourseEnrollmentRequestController {

    StudentRepository studentRepository = PersistenceContext.repositories().students();

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public CourseEnrollmentRequest courseEnrollment(Course course) {

        Username username = authz.session().get().authenticatedUser().username();

        //Student student = studentRepository.findByUsername(username);

        Student student = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> studentRepository.findByUsername(username))
                .orElse(null);

        final var newCourseEnrollment = new CourseEnrollmentRequestBuilder().theCourse(course).theStudent(student).build();

        return PersistenceContext.repositories().courseEnrollmentRequests().save(newCourseEnrollment);
    }

}
