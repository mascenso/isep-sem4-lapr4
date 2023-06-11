package eCourse.app.student.console.presentation.Exams;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<Exam> {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public void visit(final Exam visitee) {

        SystemUser loggedUser = authz.session().get().authenticatedUser();

        GradeOfExam gradeOfExam = visitee.getExamGrades().stream().filter(grade -> grade.getStudent().equals(loggedUser)).findFirst().orElse(null);

        if (gradeOfExam != null) {
            System.out.printf("%-30s%-20s%-20s%-20.2f%-20s%n", visitee.getExamTitle(), visitee.getExamCourse().identity().toString(), visitee.identity().getExamName(), gradeOfExam.getGrade(), loggedUser.name());
        }
    }

}
