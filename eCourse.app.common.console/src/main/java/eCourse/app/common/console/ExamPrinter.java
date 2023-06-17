package eCourse.app.common.console;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<Exam> {

    @Override
    public void visit(final Exam visitee) {
        System.out.printf("%-30s%-20s%-20s%-30s%-20s", visitee.getExamCourse().identity().toString(), visitee.getExamTitle().toString(), visitee.getTeacher().user().name().toString(), visitee.getExamOpenDate().toString(), visitee.getExamCloseDate().toString());
    }

}
