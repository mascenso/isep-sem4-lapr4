package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.Course;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.domain.*;
import eapli.base.repositories.ExamRepository;
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


    @Override
    public Optional<Exam> findById(Long aLong) {
        return Optional.empty();
    }


    public void deleteById(final ExamTitle id) {
        this.repo.deleteById(id);
    }

}
