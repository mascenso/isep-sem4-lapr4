package eCourse.lesson.application;

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

    /*

    public void generateOccurrences(RecurringLesson recurringLesson) {

        //recurringLesson.occurrences().clear();

        // Calculate occurrences based on frequency, start date, end date, and duration
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(recurringLesson.startDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime endDateTime = LocalDateTime.ofInstant(recurringLesson.endDate().toInstant(), ZoneId.systemDefault());

        while (currentDateTime.isBefore(endDateTime)) {
            recurringLesson.occurrences().add(currentDateTime);
            currentDateTime = currentDateTime.plusDays(recurringLesson.frequency());
        }
    }

     */

}
