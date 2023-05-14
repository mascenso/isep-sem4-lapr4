package eapli.base.lesson.application;

import eapli.base.lesson.domain.model.RecurringLesson;

public class UpdateScheduleRecurringLessonsController {

    private ListRecurringLessonsService service = new ListRecurringLessonsService();
    public Iterable<RecurringLesson> allRecurringLessons() {

        return service.allRecurringLessons();
    }
}
