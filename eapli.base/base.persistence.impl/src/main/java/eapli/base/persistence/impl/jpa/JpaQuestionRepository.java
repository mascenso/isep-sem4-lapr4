package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.Question;
import eapli.base.domain.QuestionType;
import eapli.base.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;
import java.util.Optional;

public class JpaQuestionRepository extends JpaAutoTxRepository<Question, Question, Question> implements QuestionRepository {
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
    public Optional<Question> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {

    }
}
