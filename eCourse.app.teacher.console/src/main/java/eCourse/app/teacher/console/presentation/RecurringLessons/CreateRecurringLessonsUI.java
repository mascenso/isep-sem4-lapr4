package eCourse.app.teacher.console.presentation.RecurringLessons;

import eCourse.app.teacher.console.presentation.Courses.CoursesPrinter;
import eCourse.domain.Course;
import eCourse.domain.Teacher;
import eCourse.lesson.application.CreateRecurringLessonController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CreateRecurringLessonsUI extends AbstractUI {

    //private CreateRecurringLessonController theController;

    private final CreateRecurringLessonController theController = new CreateRecurringLessonController();

    @Override
    protected boolean doShow() {

        //Teacher teacher = theController.getCurrentTeacher();
        //Course course = theController.getTeacherCourses();

        Set<Course> courseByTeacher = new HashSet<>();

        final Iterable<Course> courses = theController.getTeacherCourses();
        final SelectWidget<Course> selectorCourse = new SelectWidget<>("Select a course", courses, new CoursesPrinter());
        selectorCourse.show();
        final Course theCourse = selectorCourse.selectedElement();


        final Designation title = Designation.valueOf(Console.readNonEmptyLine("Recurring Lesson Title", "the title of the Recurring Class should not be empty."));
        final Calendar startDate = Console.readCalendar("Start date (dd/MM/yyyy)", "dd/MM/yyyy");
        Calendar endDate;
        do {
            endDate = Console.readCalendar("End Date (dd/MM/yyyy). Must be after the start date.","dd/MM/yyyy");
        } while (endDate.compareTo(startDate) <= 0);

        final LocalTime startTime =  LocalTime.parse(Console.readNonEmptyLine("Start Time (hh:mm)","hh:mm"));
        int duration;
        do {
            duration = Console.readInteger("Duration of lesson in minutes");
        } while (duration <= 0);
        int frequency;
        do {
            frequency = Console.readInteger("Frequency (day of the week) at which the lesson occurs. 1-Sunday and 7-Saturday");
        } while (frequency < 1 | frequency > 7);
        try {
            theController.createRecurringLesson(theCourse, title, startDate, endDate, startTime, duration, frequency);
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
