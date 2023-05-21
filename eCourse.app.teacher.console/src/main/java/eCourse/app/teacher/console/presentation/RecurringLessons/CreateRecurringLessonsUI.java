package eCourse.app.teacher.console.presentation.RecurringLessons;

import eCourse.lesson.application.CreateRecurringLessonController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.time.Duration;
import java.util.Calendar;

public class CreateRecurringLessonsUI extends AbstractUI {

    //private CreateRecurringLessonController theController;

    private final CreateRecurringLessonController theController = new CreateRecurringLessonController();

    @Override
    protected boolean doShow() {
        final Designation title = Designation.valueOf(Console.readNonEmptyLine("Recurring Lesson Title", "the title of the Recurring Class should not be empty."));
        final Calendar startDate = Console.readCalendar("Start date (dd/MM/yyyy hh:mm)", "dd/mm/yyyy hh:mm");
        final Calendar endDate = Console.readCalendar("End Date (dd/MM/yyyy)","dd/mm/yyyy");
        final int duration = Console.readInteger("Duration of lesson in minutes");

        try {
            theController.createRecurringLesson(title, startDate, endDate, duration);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("This Recurring Lesson already Exists in the Database.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create a new Recurring Lesson";
    }
}
