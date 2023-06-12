package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eCourse.domain.Teacher;
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
    public List<Exam> findByTeacher(Teacher teacher) {
        return null;
    }


    @Override
    public Exam findByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
        //return findByTitle(title); // comentei pq isto está mal, recursivo infinito
    }

    @Override
    public Exam findById(Long examId) {
        return null;
    }


    public void deleteById(final ExamTitle id) {
        this.repo.deleteById(id);
    }

}
