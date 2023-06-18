package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.*;
import eCourse.repositories.AutomaticExamRepository;
import eCourse.repositories.ExamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaAutomaticExamRepository extends JpaAutoTxRepository<AutomaticExame, ExamTitle, ExamTitle> implements AutomaticExamRepository {
    public JpaAutomaticExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "ExamTitle");
    }

    public JpaAutomaticExamRepository(final TransactionalContext autoTx) {
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
