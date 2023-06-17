package eCourse.lesson.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

@Entity
public class ExtraLesson extends RecurringLesson{

    public ExtraLesson(RecurringLesson recLesson, Calendar date, LocalTime startTime, int duration ) {
        super(recLesson.responsibleTeacher(),
                recLesson.recurringLessonCourse(),
                recLesson.title(),
                date, date, startTime,
                duration,
                date.get(Calendar.DAY_OF_WEEK),
                LocalDate.of(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
        );

    }

    public ExtraLesson() {
    }
}
