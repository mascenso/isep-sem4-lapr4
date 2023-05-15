package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eCourse.repositories.ExamRepository;
import java.util.List;
import java.util.Optional;

public class JpaExamRepository extends JpaAutoTxRepository<Exam, ExamTitle, ExamTitle> implements ExamRepository {
    public JpaExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "ExamTitle");
    }

    public JpaExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "ExamTitle");
    }

    @Override
    public List<Exam> findByCourse(Course course) {
        return null;
    }

    @Override
    public Optional<Exam> findByTitle(String title) {
        return Optional.empty();
    }


    public void deleteById(final ExamTitle id) {
        this.repo.deleteById(id);
    }

}
