package eapli.base.lesson.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.lesson.domain.model.RecurringLesson;
import eapli.framework.application.ApplicationService;

@ApplicationService
public class ListRecurringLessonsService {

    public Iterable<RecurringLesson> allRecurringLessons(){
        return PersistenceContext.repositories().recurringLessons().findAll();
    }

}
