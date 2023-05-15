package eapli.base.lesson.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.lesson.domain.model.RecurringLesson;

import java.time.Duration;
import java.util.Calendar;

public class UpdateScheduleRecurringLessonsController {

    private ListRecurringLessonsService service = new ListRecurringLessonsService();

    public Iterable<RecurringLesson> allRecurringLessons() {

        return service.allRecurringLessons();
    }

    public RecurringLesson updateScheduleOfRecurringLesson(RecurringLesson recurringLesson, Calendar startDate, Calendar endDate, Duration duration) {

        recurringLesson.updateScheduleOfLesson(startDate, endDate, duration);
        PersistenceContext.repositories().recurringLessons().save(recurringLesson);
        return recurringLesson;
    }
}
