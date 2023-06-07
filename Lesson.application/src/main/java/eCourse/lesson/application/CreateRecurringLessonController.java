package eCourse.lesson.application;

import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLessonBuilder;
import eCourse.lesson.domain.repositories.RecurringLessonRepository;
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

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@Component
@UseCaseController
public class CreateRecurringLessonController {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    private RecurringLessonRepository recurringLessonRepository;

    @Transactional
    public void createRecurringLesson(final Designation title, final Calendar startDate, final Calendar endDate, final LocalTime startTime, final int duration, final int frequency) {

        Username username = authz.session().get().authenticatedUser().username();

        RecurringLessonService service = new RecurringLessonService();

        Teacher teacher = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> teacherRepository.findByUsername(username))
                .orElse(null);

        List<Calendar> dayOfOccurrence = service.generateRecurringLessons(startDate, endDate, frequency);

        for (Calendar calendar : dayOfOccurrence) {

            LocalDate day = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            final var newRecurringLesson = new RecurringLessonBuilder().responsible(teacher).titled(title)
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
