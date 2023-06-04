package eCourse.lesson.application;

import eCourse.TeacherUser;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.RecurringLesson;
import eCourse.lesson.domain.model.RecurringLessonBuilder;
import eCourse.lesson.domain.repositories.RecurringLessonRepository;
import eCourse.repositories.TeacherUserRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Calendar;

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@Component
@UseCaseController
public class CreateRecurringLessonController {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    TeacherUserRepository teacherRepository = PersistenceContext.repositories().teacherUsers();

    private RecurringLessonRepository recurringLessonRepository;

    @Transactional
    public RecurringLesson createRecurringLesson(final Designation title, final Calendar startDate, final Calendar endDate, final LocalTime startTime, final int duration, final int frequency) {

        Username username = authz.session().get().authenticatedUser().username();

        TeacherUser teacher = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> teacherRepository.findByUsername(username))
                .orElse(null);

        final var newRecurringLesson = new RecurringLessonBuilder().responsible(teacher).titled(title)
                .starting(startDate).ending(endDate).startingAt(startTime)
                .lasts(duration).ocurringAt(frequency).build();

        //return recurringLessonRepository.save(newRecurringLesson);
        return PersistenceContext.repositories().recurringLessons().save(newRecurringLesson);
    }
}
