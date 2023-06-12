package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.GradeOfExam;
import eCourse.domain.Meeting;
import eCourse.repositories.GradesRepository;
import eCourse.repositories.MeetingsRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaGradesOfExamRepository extends JpaAutoTxRepository<GradeOfExam, String,String>
        implements GradesRepository {

    public JpaGradesOfExamRepository(TransactionalContext tx) {
        super(tx, "Grades of Exam repository");
    }

    public JpaGradesOfExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "Grades");
    }
    @Override
    public Optional<GradeOfExam> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}
