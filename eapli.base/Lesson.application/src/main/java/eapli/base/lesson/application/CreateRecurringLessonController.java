package eapli.base.lesson.application;

import eapli.base.lesson.domain.model.RecurringLesson;
import eapli.base.lesson.domain.model.RecurringLessonBuilder;
import eapli.base.lesson.domain.repositories.RecurringLessonRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;

import java.time.Duration;
import java.util.Calendar;

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@UseCaseController
public class CreateRecurringLessonController {

    private final RecurringLessonRepository recurringLessonRepository;

    public CreateRecurringLessonController(final RecurringLessonRepository recurringLessonRepository) {
        this.recurringLessonRepository = recurringLessonRepository;
    }

    /*public RecurringLesson createRecurringLesson(final Designation title, final Calendar startDate, final Calendar endDate, final Duration duration) {
        return RecurringLesson(title, startDate, endDate, duration);
    }

     */

    public RecurringLesson ccreateRecurringLesson(final Designation title, final Calendar startDate, final Calendar endDate, final Duration duration) {

        final var newRecurringLesson = new RecurringLessonBuilder().titled(title)
                .starting(startDate).ending(endDate)
                .lasts(duration).build();

        return recurringLessonRepository.save(newRecurringLesson);
    }
}
