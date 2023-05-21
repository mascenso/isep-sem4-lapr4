package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eCourse.repositories.ExamRepository;
import org.springframework.expression.spel.ast.NullLiteral;

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
    public Exam findByTitle(String title) {
        return findByTitle(title);
    }

    @Override
    public Exam findById(Long examId) {
        return null;
    }


    public void deleteById(final ExamTitle id) {
        this.repo.deleteById(id);
    }

}
