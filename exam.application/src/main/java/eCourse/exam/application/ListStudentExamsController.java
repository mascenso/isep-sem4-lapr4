package eCourse.exam.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.StudentUserRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListStudentExamsController {

    private final ListCoursesService courseService = new ListCoursesService();
    private final ListExamsService examService = new ListExamsService();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();
    StudentUserRepository studentRepository = PersistenceContext.repositories().studentUsers();

    public Iterable<Course> allCourses() {
        return courseService.allCourses();
    }

    public Iterable<Exam> allExams() {

        return examService.allExams();
    }

    public Iterable<Exam> examOfLoggedStudent() {
        Student student = loggedStudent();
        return examService.examOfLoggedStudent(student);
    }

    public Student loggedStudent() {
        Username loggedUser = authz.session().get().authenticatedUser().username();

        Student student = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> studentRepository.findByUsername(loggedUser))
                .orElse(null);

        return student;
    }

}
