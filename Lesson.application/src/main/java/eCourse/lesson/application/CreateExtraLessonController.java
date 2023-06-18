package eCourse.lesson.application;

import eCourse.domain.Course;
import eCourse.domain.Student;
import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.lesson.domain.model.ExtraLesson;
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
import java.util.*;

/**
 *  The controller for the use case "Schedule a Class" using the domain objects.
 *
 */
@Component
@UseCaseController
public class CreateExtraLessonController {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();
    private RecurringLessonRepository repository = PersistenceContext.repositories().recurringLessons();
    private ListRecurringLessonsService listService = new ListRecurringLessonsService();
    RecurringLessonService RLessonService = new RecurringLessonService();

    public Set<RecurringLesson> allRecurringLessons() {
        return listService.allRecurringLessonsId();
    }


    public void createExtraLesson(RecurringLesson theRecurringLesson, Set<Student> participantsInExtraClass, Calendar startDate, LocalTime startTime, int duration) {

        ExtraLesson extraLesson = new ExtraLesson(theRecurringLesson, startDate, startTime, duration);

        if(RLessonService.validateRecurringLesson(extraLesson.responsibleTeacher(), extraLesson)) {
            this.repository.save(extraLesson);
        }
        else {
            throw new IllegalStateException("The recurring lesson is not valid");
        }

    }
}
