package eCourse.app.teacher.console.presentation.exam;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eCourse.domain.Teacher;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.visitor.Visitor;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherExamGradesPrinter implements Visitor<Exam> {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public void visit(final Exam visitee) {

        SystemUser loggedUser = authz.session().get().authenticatedUser();

        if (visitee.getTeacher().systemUser().equals(loggedUser)) {
            for (GradeOfExam gradeOfExam : visitee.getExamGrades()) {
                System.out.printf("%-30s%-20s%-20s%-20.2f%-20s%n",
                        visitee.getExamTitle(), visitee.getExamCourse().identity().toString(),
                        visitee.identity().getExamName(), gradeOfExam.getGrade(), gradeOfExam.getStudent().name());
            }
        }
    }
}
