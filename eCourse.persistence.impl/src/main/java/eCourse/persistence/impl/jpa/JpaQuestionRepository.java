package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eCourse.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
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
    public Optional<Question> findByQuestionType(QuestionType questionType) {
        final Map<String, Object> params = new HashMap<>();
        params.put("QuestionType", questionType);
        return matchOne("e.name=:QuestionType", params);
    }

    @Override
    public Optional<Question> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}
