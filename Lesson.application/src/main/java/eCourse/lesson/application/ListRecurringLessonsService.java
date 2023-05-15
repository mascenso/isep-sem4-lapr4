package eCourse.lesson.application;

import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.application.ApplicationService;

@ApplicationService
public class ListRecurringLessonsService {

    public Iterable<RecurringLesson> allRecurringLessons(){
        return PersistenceContext.repositories().recurringLessons().findAll();
    }

}
