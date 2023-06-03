package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.repositories.CourseEnrollmentRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaCourseEnrollmentRequestRepository extends JpaAutoTxRepository<CourseEnrollmentRequest, Long, String>
implements CourseEnrollmentRequestRepository {

    /*
    public class JpaMeetingRepository extends JpaAutoTxRepository<Meeting, String,String>
        implements MeetingsRepository {
     */

    public JpaCourseEnrollmentRequestRepository(final TransactionalContext autoTx) {
        super(autoTx, "CourseEnrollmentID");
    }

    public JpaCourseEnrollmentRequestRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "CourseEnrollmentID");
    }

/*
    @Override
    public Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests() {
        return null;
    }


 */
    @Override
    public Optional<CourseEnrollmentRequest> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public Iterable<CourseEnrollmentRequest> pendingCourseEnrollmentRequests() {
        return null;
    }
}
