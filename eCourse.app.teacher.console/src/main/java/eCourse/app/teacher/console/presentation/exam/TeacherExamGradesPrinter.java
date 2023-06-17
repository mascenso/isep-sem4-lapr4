package eCourse.app.teacher.console.presentation.exam;

import eCourse.domain.GradeOfExam;
import eapli.framework.visitor.Visitor;

public class TeacherExamGradesPrinter implements Visitor<GradeOfExam> {

    @Override
    public void visit(final GradeOfExam visitee) {
                System.out.printf("%-30s%-20s%-20s%-20.2f%-20s", visitee.theExam().getExamCourse().identity().toString(), visitee.theExam().getExamTitle().toString(), visitee.theExam().getTeacher().user().name().toString(), visitee.gradeResult(), visitee.studentWhoDidExam().name().toString());
    }
}
