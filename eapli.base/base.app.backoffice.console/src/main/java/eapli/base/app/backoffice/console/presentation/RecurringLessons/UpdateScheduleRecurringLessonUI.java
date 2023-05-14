package eapli.base.app.backoffice.console.presentation.RecurringLessons;

import eapli.base.lesson.application.UpdateScheduleRecurringLessonsController;
import eapli.base.lesson.domain.model.RecurringLesson;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
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
            System.out.printf("(%d) %s %s %s",position, lesson.title(), lesson.startDate(), lesson.duration());
            lessonList.add(lesson);
            position ++;
        }

        int chooseLesson = Console.readInteger("Lesson");

        System.out.println("(1) Start date");
        System.out.println("(2) End date");
        System.out.println("(3) Duration");

        int chooseChange = Console.readInteger("Which one do you want to update?");

        return false;
    }

    @Override
    public String headline() {
        return "Update schedule of Lesson";
    }

}
