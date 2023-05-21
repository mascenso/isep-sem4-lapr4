package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eCourse.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;
import java.util.Optional;

public class JpaQuestionRepository extends JpaAutoTxRepository<Question, Long, Long> implements QuestionRepository {
    public JpaQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "Question");
    }
    public JpaQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "Question");
    }

    @Override
    public List<Question> findByQuestionType(QuestionType questionType) {
        return null;
    }

    @Override
    public Optional<Question> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}
