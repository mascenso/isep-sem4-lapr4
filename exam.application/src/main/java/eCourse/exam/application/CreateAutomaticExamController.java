package eCourse.exam.application;

import eCourse.course.application.ListCoursesService;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.AutomaticExamRepository;
import eCourse.repositories.CourseRepository;
import eCourse.repositories.TeacherRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@UseCaseController
@Component
public class CreateAutomaticExamController {
    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    @Autowired
    private AutomaticExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    public Teacher getCurrentTeacher() {
        Username username = authz.session().get().authenticatedUser().username();

        Teacher teacher = authz.session()
                .map(UserSession::authenticatedUser)
                .flatMap(systemUser -> teacherRepository.findByUsername(username))
                .orElse(null);
        return teacher;
    }


    @Transactional
    public AutomaticExame createExam(final Course course, final Teacher teacher, final String title, final File file) {

        ExamTitle examTitle=ExamTitle.valueOf(title);
        final AutomaticExame automaticExame = new AutomaticExame(examTitle,course,teacher,file);
        return PersistenceContext.repositories().automaticExams().save(automaticExame);
    }

    public List<Course> getOpenCourses() {
        return courseService.getOpenCourses();
    }

    public ExamTitle getExamTitle(String title) {
        return ExamTitle.valueOf(title);
    }
}
