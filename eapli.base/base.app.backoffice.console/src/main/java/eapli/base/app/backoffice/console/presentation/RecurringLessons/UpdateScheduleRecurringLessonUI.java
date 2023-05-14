package eapli.base.app.backoffice.console.presentation.RecurringLessons;

import eapli.base.lesson.application.UpdateScheduleRecurringLessonsController;
import eapli.base.lesson.domain.model.RecurringLesson;
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

        Calendar startDate = Console.readCalendar("A data antiga é " + lessonList.get(chooseLesson).startDate().getTime() + " que valor deseja colocar?","dd/mm/yyyy hh:mm");
        Calendar endDate = Console.readCalendar("A data antiga é " + lessonList.get(chooseLesson).endDate().getTime() + " que valor deseja colocar?","dd/mm/yyyy");
        Duration duration = Duration.ofMinutes(Console.readInteger("A data antiga é " + lessonList.get(chooseLesson).startDate().toString() + " que valor deseja colocar?"));

        RecurringLesson updatedLesson = theController.updateScheduleOfRecurringLesson(lessonList.get(chooseLesson),startDate,endDate,duration);

        return false;
    }

    @Override
    public String headline() {
        return "Update schedule of Lesson";
    }

}
