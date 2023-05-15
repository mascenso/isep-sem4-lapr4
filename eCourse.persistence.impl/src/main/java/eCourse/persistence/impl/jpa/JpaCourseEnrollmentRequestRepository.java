package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.repositories.CourseEnrollmentRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCourseEnrollmentRequestRepository extends JpaAutoTxRepository<CourseEnrollmentRequest, Username, Username>
implements CourseEnrollmentRequestRepository {

    public JpaCourseEnrollmentRequestRepository(final TransactionalContext autoTx) {
        super(autoTx, "StudentUsername");
    }

    public JpaCourseEnrollmentRequestRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "StudentUsernane");
    }


    @Override
    public Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests() {
        return null;
    }
}
