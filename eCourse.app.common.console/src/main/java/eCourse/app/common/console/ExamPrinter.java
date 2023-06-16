package eCourse.app.common.console;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<GradeOfExam> {

    @Override
    public void visit(final GradeOfExam visitee) {
        System.out.printf("%-30s%-20s%-20.2f%-20s%n", visitee.theExam().getExamCourse().identity().toString(), visitee.theExam().identity().toString(), visitee.gradeResult(), visitee.studentWhoDidExam().name().toString());
    }

}
