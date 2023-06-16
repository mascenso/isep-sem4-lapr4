package eCourse.app.teacher.console.presentation.RecurringLessons;

import eCourse.app.common.console.teachers.StudentPrinter;
import eCourse.domain.Student;
import eCourse.lesson.application.CreateExtraLessonController;
import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CreateExtraLessonUI extends AbstractUI {

    private final CreateExtraLessonController theController = new CreateExtraLessonController();

    @Override
    protected boolean doShow() {

        Set<Student> participantsInExtraClass = new HashSet<>();

        final Iterable<RecurringLesson> lessons = theController.allRecurringLessons();
        final SelectWidget<RecurringLesson> selectorLesson = new SelectWidget<>("Select a lesson", lessons, new LessonsPrinter());
        selectorLesson.show();
        final RecurringLesson theRecurringLesson = selectorLesson.selectedElement();

        if (theRecurringLesson != null) {

            /* Selects the set of students to be added to the extra class */
            while (true) {
                final Iterable<Student> listOfStudents = new HashSet<>();//theController.allParticipants();

                final SelectWidget<Student> selectorStudent = new SelectWidget<>("Select a student", listOfStudents, new StudentPrinter());
                selectorStudent.show();
                final Student theStudent = selectorStudent.selectedElement();

                if (theStudent != null) {
                    participantsInExtraClass.add(theStudent);
                } else {
                    break;
                }
            }

            /* RecurringLesson recLesson, Calendar date, LocalTime startTime, int duration*/

            final Calendar startDate = Console.readCalendar("Extra lesson date (dd/MM/yyyy)", "dd/MM/yyyy");

            final LocalTime startTime =  LocalTime.parse(Console.readNonEmptyLine("Start Time (hh:mm)","hh:mm"));

            int duration = Console.readInteger("Duration of lesson in minutes");


            if (!participantsInExtraClass.isEmpty())
            {
                try {
                    //todo: add participants
                    theController.createExtraLesson(theRecurringLesson, participantsInExtraClass, startDate, startTime, duration);
                } catch (final ConcurrencyException | IntegrityViolationException exMerge) {
                    System.out.println("Data has changed or been deleted since it was last read. Please try again.");
                }
            }
            else {
                System.out.println("No students were selected.");
                theController.createExtraLesson(theRecurringLesson, participantsInExtraClass, startDate, startTime, duration);
            }

        }

        return false;
    }

    @Override
    public String headline() {
        return "Create a new Recurring Lesson";
    }
}
