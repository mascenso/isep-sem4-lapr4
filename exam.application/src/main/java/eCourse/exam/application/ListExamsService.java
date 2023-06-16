package eCourse.exam.application;

import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class ListExamsService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<Exam> allExams(){
        return PersistenceContext.repositories().exams().findAll();
    }

    public List<GradeOfExam> examOfLoggedStudent() {
        List<GradeOfExam> loggedStudentExams = new ArrayList<>();
        SystemUser loggedUser = authz.session().get().authenticatedUser();
        for (Exam exam : allExams()) {
            GradeOfExam gradeOfExam = exam.getExamGrades().stream().filter(grade -> grade.studentWhoDidExam().equals(loggedUser)).findFirst().orElse(null);
            if(gradeOfExam != null) {
                loggedStudentExams.add(gradeOfExam);
            }
        }
        return loggedStudentExams;
    }

    public List<Exam> getExamByCourse(Course course) {
        List<Exam> examListByCourse = new ArrayList<>();
        for (Exam exm : allExams()) {
            if (exm.getExamCourse().equals(course)) {
                examListByCourse.add(exm);
            }
        }
        return examListByCourse;
    }


    public Iterable<Exam> ExamsUnsolved(){
        return PersistenceContext.repositories().exams().findAll();
    }
}
