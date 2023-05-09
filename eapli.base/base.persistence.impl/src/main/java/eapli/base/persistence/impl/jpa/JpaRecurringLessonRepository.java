package eapli.base.persistence.impl.jpa;

import eapli.base.lesson.domain.model.RecurringLesson;
import eapli.base.lesson.domain.repositories.RecurringLessonRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Map;
import java.util.Optional;

public class JpaRecurringLessonRepository extends JpaAutoTxRepository<RecurringLesson, RecurringLesson, RecurringLesson> implements RecurringLessonRepository {

    public JpaRecurringLessonRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaRecurringLessonRepository(String persistenceUnitName, Map properties, String identityFieldName) {
        super(persistenceUnitName, properties, identityFieldName);
    }

    public JpaRecurringLessonRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, identityFieldName);
    }

    @Override
    public Iterable<RecurringLesson> findAllRecurringLesson() { return null;}

    @Override
    public Optional<RecurringLesson> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {

    }
}
