package eCourse.lesson.domain.model;

import eCourse.domain.*;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RecurringLessonTest {

    private RecurringLesson lesson1;
    private RecurringLesson lesson2;
    private RecurringLesson lesson3;
    private Designation title1;
    private Designation title2;
    private Role TEACHER;
    private Set<Role> roles1 = new HashSet<>();
    private SystemUser teacher;
    private Teacher teacher1;
    private Teacher teacher2;
    private Course course1;
    private Course course2;
    private Calendar startDate1;
    private Calendar startDate2;
    private Calendar endDate1;
    private Calendar endDate2;
    private LocalTime startTime1;
    private LocalTime startTime2;
    private int duration1;
    private int duration2;
    private int frequency1;
    private int frequency2;
    private LocalDate occurrences1;
    private LocalDate occurrences2;

    @BeforeEach
    public void setUp() throws ParseException {
        title1 = Designation.valueOf("EAPLI-2NA");
        title2 = Designation.valueOf("EAPLI-2NB");
        TEACHER = Role.valueOf("TEACHER");
        roles1.add(TEACHER);
        SystemUser teacher = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder()).with("Mig", "teste", "Miguel", "Seixas", "miguel@isep.pt").withRoles(roles1).build();
        teacher1 = new TeacherBuilder().withAcronym("MMA").withSystemUser(teacher).build();
        teacher2 = new TeacherBuilder().withAcronym("MSE").withSystemUser(teacher).build();
        course1 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("ESOFT")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();
        course2 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("EAPLI")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();
        startDate1 = Calendar.getInstance();
        startDate2 = Calendar.getInstance();
        endDate1 = Calendar.getInstance();
        endDate2 = Calendar.getInstance();
        startTime1 = LocalTime.parse("10:00");
        startTime2 = LocalTime.parse("11:00");
        duration1 = 50;
        duration2 = 60;
        frequency1 = 2;
        frequency2 = 3;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        occurrences1 = LocalDate.parse("01/05/2023", formatter);
        occurrences2 = LocalDate.parse("02/05/2023", formatter);


        lesson1 = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        lesson2 = new RecurringLessonBuilder().titled(title2).responsible(teacher2).teachedAt(course2).starting(startDate2).ending(endDate2)
                .startingAt(startTime2).lasts(duration2).ocurringAt(frequency2).happensAt(occurrences2).build();
        lesson3 = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

    }

    @Test
    public void testIfRecurringLessonTitleIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Teacher nullTeacher = null;
            new RecurringLessonBuilder().titled(title1).responsible(nullTeacher).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).build();
        });
    }

    @Test
    public void testIfRecurringLessonResponsibleIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Designation nullTitle = null;
            new RecurringLessonBuilder().titled(nullTitle).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).build();
        });
    }

    @Test
    public void testIfRecurringLessonCourseIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Course nullCourse = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(nullCourse).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonStartDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Calendar nullStartDate = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(nullStartDate).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonEndDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Calendar nullEndDate = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(nullEndDate)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonStartTimeIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            LocalTime nullStartTime = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(nullStartTime).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonOccurrencesIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            LocalDate nullOccurrence = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(nullOccurrence).build();
        });
    }

    @Test
    public void testIfAllParametersAreFilled() {
        assertDoesNotThrow(() -> {
            RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

            assertEquals(title1, recurringLesson.title());
            assertEquals(course1, recurringLesson.recurringLessonCourse());
            assertEquals(teacher1, recurringLesson.responsibleTeacher());
            assertEquals(startDate1, recurringLesson.startDate());
            assertEquals(endDate1, recurringLesson.endDate());
            assertEquals(startTime1, recurringLesson.startTime());
            assertEquals(duration1, recurringLesson.duration());
            assertEquals(frequency1, recurringLesson.frequency());
            assertEquals(occurrences1, recurringLesson.occurrences());
        });
    }

    @Test
    public void testIfRecurringLessonTitleIsCorrect() {
        assertEquals(title1, lesson1.title());
        assertEquals(title2, lesson2.title());
        assertNotEquals(title2, lesson1.title());
    }

    @Test
    public void testIfRecurringLessonCourseIsCorrect() {
        assertEquals(course1, lesson1.recurringLessonCourse());
        assertEquals(course2, lesson2.recurringLessonCourse());
        assertNotEquals(course2, lesson1.recurringLessonCourse());
    }

    @Test
    public void testIfRecurringLessonTeacherIsCorrect() {
        assertEquals(teacher1, lesson1.responsibleTeacher());
        assertEquals(teacher2, lesson2.responsibleTeacher());
        assertNotEquals(teacher2, lesson1.responsibleTeacher());
    }

    @Test
    public void testIfRecurringLessonStartDateIsCorrect() {
        assertEquals(startDate1, lesson1.startDate());
        assertEquals(startDate2, lesson2.startDate());
    }

    @Test
    public void testIfRecurringLessonEndDateIsCorrect() {
        assertEquals(endDate1, lesson1.endDate());
        assertEquals(endDate2, lesson2.endDate());
    }

    @Test
    public void testIfRecurringLessonStartTimeIsCorrect() {
        assertEquals(startTime1, lesson1.startTime());
        assertEquals(startTime2, lesson2.startTime());
        assertNotEquals(startTime2, lesson1.startTime());
    }

    @Test
    public void testIfRecurringLessonDurationIsCorrect() {
        assertEquals(duration1, lesson1.duration());
        assertEquals(duration2, lesson2.duration());
        assertNotEquals(duration2, lesson1.duration());
    }

    @Test
    public void testIfRecurringLessonFrequencyIsCorrect() {
        assertEquals(frequency1, lesson1.frequency());
        assertEquals(frequency2, lesson2.frequency());
        assertNotEquals(frequency2, lesson1.frequency());
    }

    @Test
    public void testIfRecurringLessonOccurrencesIsCorrect() {
        assertEquals(occurrences1, lesson1.occurrences());
        assertEquals(occurrences2, lesson2.occurrences());
        assertNotEquals(occurrences2, lesson1.occurrences());
    }

    @Test
    public void testCreateRecurringLesson() {
        RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

        assertEquals(title1, recurringLesson.title());
        assertEquals(course1, recurringLesson.recurringLessonCourse());
        assertEquals(teacher1, recurringLesson.responsibleTeacher());
        assertEquals(startDate1, recurringLesson.startDate());
        assertEquals(endDate1, recurringLesson.endDate());
        assertEquals(startTime1, recurringLesson.startTime());
        assertEquals(duration1, recurringLesson.duration());
        assertEquals(frequency1, recurringLesson.frequency());
        assertEquals(occurrences1, recurringLesson.occurrences());
    }

    @Test
    public void testUpdateRecurringLesson() {
        RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();


        Calendar newStartDate = Calendar.getInstance();
        Calendar newEndDate = Calendar.getInstance();
        int newDuration = 45;

        recurringLesson.updateScheduleOfLesson(newStartDate, newEndDate, newDuration);

        assertEquals(newStartDate, recurringLesson.startDate());
        assertEquals(newEndDate, recurringLesson.endDate());
        assertEquals(newDuration, recurringLesson.duration());
    }

    @Test
    public void testEqualsRecurringLessons() {

        assertTrue(lesson1.sameAs(lesson3));
    }

    @Test
    public void testNotEqualsRecurringLessons() {

        assertFalse(lesson1.sameAs(lesson2));
    }


}