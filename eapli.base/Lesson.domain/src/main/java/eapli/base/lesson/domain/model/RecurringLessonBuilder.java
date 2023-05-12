package eapli.base.lesson.domain.model;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

import java.time.Duration;
import java.util.Calendar;

public class RecurringLessonBuilder implements DomainFactory<RecurringLesson> {

    private RecurringLesson theRecurringLesson;

    private Designation title;

    private Calendar startDate;

    private Calendar endDate;

    private Duration duration;

    public RecurringLessonBuilder titled(final Designation title) {
        this.title = title;
        return this;
    }

    public RecurringLessonBuilder starting(final Calendar startDate) {
        this.startDate = startDate;
        return this;
    }

    public RecurringLessonBuilder ending(final Calendar endDate) {
        this.endDate = endDate;
        return this;
    }

    public RecurringLessonBuilder lasts(final Duration duration) {
        this.duration = duration;
        return this;
    }

    private RecurringLesson buildOrThrow() {
        if (theRecurringLesson != null) {
            return theRecurringLesson;
        }
        if (title != null && startDate != null && endDate != null && duration != null) {
            theRecurringLesson = new RecurringLesson(title, startDate, endDate, duration);
            return theRecurringLesson;
        }
        throw new IllegalStateException();
    }

    @Override
    public RecurringLesson build() {
        final var ret = buildOrThrow();
        theRecurringLesson = null;
        return ret;
    }
}
