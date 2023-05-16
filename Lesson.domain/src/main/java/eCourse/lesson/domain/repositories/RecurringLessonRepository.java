package eCourse.lesson.domain.repositories;

import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;

public interface RecurringLessonRepository extends DomainRepository<Designation, RecurringLesson> {

    /**
     * This is just a placeholder for the findAllRecurringLesson method that will receive a Teacher as a parameter
     * @return
     */
    Iterable<RecurringLesson> findAllRecurringLesson();
}
