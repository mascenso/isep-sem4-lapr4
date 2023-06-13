package eCourse.lesson.application;

import eCourse.domain.Course;
import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;
import eCourse.lesson.domain.repositories.RecurringLessonRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecurringLessonService {

    public Iterable<RecurringLesson> allRecurringLessons() {
        return PersistenceContext.repositories().recurringLessons().findAll();
    }

    public List<Calendar> generateRecurringLessons(Calendar startDate, Calendar endDate, int frequency) {
        List<Calendar> daysOfRecurringLesson = new ArrayList<>();

        Calendar currentLessonDate = startDate;
        while (!currentLessonDate.after(endDate)) {
            int day = currentLessonDate.get(Calendar.DAY_OF_WEEK);
            if (day == frequency) {
                // Had to make a clone here or else all days were the same
                daysOfRecurringLesson.add((Calendar) currentLessonDate.clone());
            }
            currentLessonDate.add(Calendar.DAY_OF_MONTH, 1);
        }

        return daysOfRecurringLesson;
    }

    public boolean validateRecurringLesson(Teacher teacher, RecurringLesson recurringLesson) {
        LocalDate day = recurringLesson.occurrences();
        for (RecurringLesson lesson : allRecurringLessons()) {
            if (lesson.responsibleTeacher().equals(teacher) && lesson.occurrences().equals(recurringLesson.occurrences()) && lesson.startTime().equals(recurringLesson.startTime())) {
                return false;
            }
        }
        return true;
    }

}
