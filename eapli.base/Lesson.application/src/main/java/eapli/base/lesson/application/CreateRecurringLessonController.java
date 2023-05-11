package eapli.base.lesson.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.lesson.domain.model.RecurringLesson;
import eapli.base.lesson.domain.model.RecurringLessonBuilder;
import eapli.base.lesson.domain.repositories.RecurringLessonRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Calendar;

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@Component
@UseCaseController
public class CreateRecurringLessonController {

    @Autowired
    private RecurringLessonRepository recurringLessonRepository;

    /*
    public CreateRecurringLessonController(final RecurringLessonRepository recurringLessonRepository) {
        this.recurringLessonRepository = recurringLessonRepository;
    }


     */
    @Transactional
    public RecurringLesson createRecurringLesson(final Designation title, final Calendar startDate, final Calendar endDate, final Duration duration) {

        final var newRecurringLesson = new RecurringLessonBuilder().titled(title)
                .starting(startDate).ending(endDate)
                .lasts(duration).build();

        //return recurringLessonRepository.save(newRecurringLesson);
        return PersistenceContext.repositories().recurringLessons().save(newRecurringLesson);
    }
}
