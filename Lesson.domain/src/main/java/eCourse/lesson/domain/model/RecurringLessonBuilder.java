package eCourse.lesson.domain.model;

import eCourse.domain.Course;
import eCourse.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class RecurringLessonBuilder implements DomainFactory<RecurringLesson> {

    private RecurringLesson theRecurringLesson;

    private Teacher responsibleTeacher;

    private Course recurringLessonCourse;

    private Designation title;

    private Calendar startDate;

    private Calendar endDate;

    private LocalTime startTime;

    private int duration;

    private int frequency;

    private LocalDate occurrences;

    public RecurringLessonBuilder responsible(final Teacher responsibleTeacher) {
        this.responsibleTeacher = responsibleTeacher;
        return this;
    }

    public RecurringLessonBuilder teachedAt(final Course recurringLessonCourse) {
        this.recurringLessonCourse = recurringLessonCourse;
        return this;
    }

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

    public RecurringLessonBuilder startingAt(final LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public RecurringLessonBuilder lasts(final int duration) {
        this.duration = duration;
        return this;
    }

    public RecurringLessonBuilder ocurringAt(final int frequency) {
        this.frequency = frequency;
        return this;
    }

    public RecurringLessonBuilder happensAt(final LocalDate occurrences) {
        this.occurrences = occurrences;
        return this;
    }

    private RecurringLesson buildOrThrow() {
        if (theRecurringLesson != null) {
            return theRecurringLesson;
        }
        if (responsibleTeacher != null && recurringLessonCourse != null && title != null && startDate != null && endDate != null && startTime != null  && occurrences != null && duration > 0 && frequency > 0 && frequency < 8) {
            theRecurringLesson = new RecurringLesson(responsibleTeacher, recurringLessonCourse,title, startDate, endDate, startTime, duration, frequency, occurrences);
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
