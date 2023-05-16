package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.lesson.domain.model.RecurringLesson;
import eCourse.lesson.domain.repositories.RecurringLessonRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaRecurringLessonRepository extends JpaAutoTxRepository<RecurringLesson, RecurringLesson, RecurringLesson> implements RecurringLessonRepository {

    public JpaRecurringLessonRepository(final TransactionalContext autoTx) { super(autoTx, "LessonTitle");}

    public JpaRecurringLessonRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "RecurringLessonTitle");
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
