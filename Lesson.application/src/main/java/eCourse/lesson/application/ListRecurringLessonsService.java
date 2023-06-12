package eCourse.lesson.application;

import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.application.ApplicationService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@ApplicationService
public class ListRecurringLessonsService {

    public Iterable<RecurringLesson> allRecurringLessons(){
        return PersistenceContext.repositories().recurringLessons().findAll();
    }

    public Set<RecurringLesson> allRecurringLessonsId(){
        return  new HashSet<>((Collection<? extends RecurringLesson>) PersistenceContext.repositories().recurringLessons().findAll());
    }

}
