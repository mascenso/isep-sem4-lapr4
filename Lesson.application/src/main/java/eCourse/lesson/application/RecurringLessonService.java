package eCourse.lesson.application;

import eCourse.TeacherUser;
import eCourse.lesson.domain.model.RecurringLesson;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecurringLessonService {

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

    public boolean validateRecurringLesson(TeacherUser teacher, RecurringLesson recurringLesson) {
        return true;
    }

}
