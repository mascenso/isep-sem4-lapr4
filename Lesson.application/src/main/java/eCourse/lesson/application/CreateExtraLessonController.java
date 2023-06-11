package eCourse.lesson.application;

import eCourse.domain.Course;
import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;
import eCourse.lesson.domain.model.RecurringLessonBuilder;
import eCourse.lesson.domain.repositories.RecurringLessonRepository;
import eCourse.repositories.CourseRepository;
import eCourse.repositories.TeacherRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@Component
@UseCaseController
public class CreateExtraLessonController {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();
    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();
    CourseRepository courseRepository = PersistenceContext.repositories().courses();
    private RecurringLessonRepository recurringLessonRepository;
    private ListRecurringLessonsService service = new ListRecurringLessonsService();

    public Iterable<RecurringLesson> allRecurringLessons() {
        return service.allRecurringLessons();
    }

    public Teacher getCurrentTeacher() {
        Username username = authz.session().get().authenticatedUser().username();

        Teacher teacher = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> teacherRepository.findByUsername(username))
                .orElse(null);

        return teacher;
    }

    public Iterable<Course> getTeacherCourses() {
        Teacher teacher = getCurrentTeacher();
        Iterable<Course> courses = courseRepository.findByTeacher(teacher);
        if (!courses.iterator().hasNext()){
            throw new IllegalStateException("No courses found for the teacher");
        }
        return courses;
    }

    @Transactional
    public void createRecurringLesson(final Course course, final Designation title, final Calendar startDate, final Calendar endDate, final LocalTime startTime, final int duration, final int frequency) {

        Username username = authz.session().get().authenticatedUser().username();

        RecurringLessonService service = new RecurringLessonService();

        Teacher teacher = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> teacherRepository.findByUsername(username))
                .orElse(null);

        List<Calendar> dayOfOccurrence = service.generateRecurringLessons(startDate, endDate, frequency);

        for (Calendar calendar : dayOfOccurrence) {

            LocalDate day = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            final var newRecurringLesson = new RecurringLessonBuilder().responsible(teacher).teachedAt(course).titled(title)
                    .starting(startDate).ending(endDate).startingAt(startTime)
                    .lasts(duration).ocurringAt(frequency).happensAt(day).build();

            if(service.validateRecurringLesson(teacher, newRecurringLesson)) {
                PersistenceContext.repositories().recurringLessons().save(newRecurringLesson);
            } else {
                throw new IllegalStateException("Invalid recurring lesson");
            }
            //return recurringLessonRepository.save(newRecurringLesson);
        }

    }
}
