package eCourse.app.backoffice.console.presentation.RecurringLessons;

import eCourse.lesson.application.UpdateScheduleRecurringLessonsController;
import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpdateScheduleRecurringLessonUI extends AbstractUI {

    private UpdateScheduleRecurringLessonsController theController = new UpdateScheduleRecurringLessonsController();

    @Override
    protected boolean doShow() {

        System.out.println("Select the Lesson to update:");

        Iterable<RecurringLesson> listOfLessons = theController.allRecurringLessons();
        List<RecurringLesson> lessonList = new ArrayList<>();

        int position = 0;
        for (RecurringLesson lesson: listOfLessons) {
            System.out.printf("(%d) %s %s %s %s",position, lesson.title(), lesson.startDate().getTime(), lesson.endDate().getTime(), lesson.duration().toString());
            lessonList.add(lesson);
            position ++;
        }

        int chooseLesson = Console.readInteger("Lesson");

        Calendar startDate = Console.readCalendar("The old start date is " + lessonList.get(chooseLesson).startDate().getTime() + " what value you want to enter?","dd/mm/yyyy hh:mm");
        Calendar endDate = Console.readCalendar("The old end date is " + lessonList.get(chooseLesson).endDate().getTime() + " what value you want to enter?","dd/mm/yyyy");
        Duration duration = Duration.ofMinutes(Console.readInteger("The old duration is " + lessonList.get(chooseLesson).startDate().toString() + " what value you want to enter?"));

        theController.updateScheduleOfRecurringLesson(lessonList.get(chooseLesson),startDate,endDate,duration);

        return false;
    }

    @Override
    public String headline() {
        return "Update schedule of Lesson";
    }

}
