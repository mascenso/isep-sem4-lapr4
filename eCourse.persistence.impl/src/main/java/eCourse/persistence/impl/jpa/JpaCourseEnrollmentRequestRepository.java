package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.EnrollmentStatus;
import eCourse.domain.Student;
import eCourse.repositories.CourseEnrollmentRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCourseEnrollmentRequestRepository extends JpaAutoTxRepository<CourseEnrollmentRequest, Long, String>
        implements CourseEnrollmentRequestRepository {

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
        TypedQuery<CourseEnrollmentRequest> query = entityManager().createQuery(
                "SELECT cer FROM CourseEnrollmentRequest cer WHERE cer.enrollmentStatus = :status",
                CourseEnrollmentRequest.class);
        query.setParameter("status", EnrollmentStatus.PENDING);

        return query.getResultList();
    }

    @Override
    public CourseEnrollmentRequest findByStudentAndCourse(Student student, Course course) {
        TypedQuery<CourseEnrollmentRequest> query = entityManager().createQuery(
                "SELECT cer FROM CourseEnrollmentRequest cer WHERE cer.student = :student AND cer.course = :course",
                CourseEnrollmentRequest.class);
        query.setParameter("student", student);
        query.setParameter("course", course);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // No matching enrollment request found
        }

    }

}
