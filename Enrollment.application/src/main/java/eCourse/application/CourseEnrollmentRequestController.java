package eCourse.application;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.StudentUserRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;

@UseCaseController
public class CourseEnrollmentRequestController {

    StudentUserRepository studentRepository = PersistenceContext.repositories().studentUsers();

    CourseEnrollmentRequestService service = new CourseEnrollmentRequestService();

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Transactional
    public boolean courseEnrollment(Course course) {

        Username username = authz.session().get().authenticatedUser().username();

        //Student student = studentRepository.findByUsername(username);

        Student student = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> studentRepository.findByUsername(username))
                .orElse(null);

        final var newCourseEnrollment = new CourseEnrollmentRequestBuilder().theCourse(course).theStudent(student).build();

        if(service.validateCourseEnrollmentRequest(student, course)) {
            PersistenceContext.repositories().courseEnrollmentRequests().save(newCourseEnrollment);
            return true;
        } else {
            return false;
        }

    }

}
