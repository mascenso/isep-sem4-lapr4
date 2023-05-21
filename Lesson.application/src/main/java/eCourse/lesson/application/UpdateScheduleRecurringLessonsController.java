package eCourse.lesson.application;

import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.application.ListRecurringLessonsService;
import eCourse.lesson.domain.model.RecurringLesson;

import java.time.Duration;
import java.util.Calendar;

public class UpdateScheduleRecurringLessonsController {

    private ListRecurringLessonsService service = new ListRecurringLessonsService();

    public Iterable<RecurringLesson> allRecurringLessons() {

        return service.allRecurringLessons();
    }

    public RecurringLesson updateScheduleOfRecurringLesson(RecurringLesson recurringLesson, Calendar startDate, Calendar endDate, int duration) {

        recurringLesson.updateScheduleOfLesson(startDate, endDate, duration);
        PersistenceContext.repositories().recurringLessons().save(recurringLesson);
        return recurringLesson;
    }
}
