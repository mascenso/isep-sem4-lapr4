package eCourse.app.common.console;

import eCourse.domain.GradeOfExam;
import eapli.framework.visitor.Visitor;

public class ExamGradePrinter implements Visitor<GradeOfExam> {

    @Override
    public void visit(final GradeOfExam visitee) {
        if(visitee.theExam()==null){
            System.out.printf("%-30s%-20s%-20.2f%-20s",
                    visitee.theAutomaticExam().getExamCourse().identity().toString(),
                    visitee.theAutomaticExam().identity().toString(),
                    visitee.gradeResult(),
                    visitee.studentWhoDidExam().name().toString());
        }else{
            System.out.printf("%-30s%-20s%-20.2f%-20s",
                    visitee.theExam().getExamCourse().identity().toString(),
                    visitee.theExam().identity().toString(),
                    visitee.gradeResult(),
                    visitee.studentWhoDidExam().name().toString());
        }
    }

}
