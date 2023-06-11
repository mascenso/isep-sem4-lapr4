package eCourse.app.common.console;

import eCourse.domain.Exam;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<Exam> {
    @Override
    public void visit(final Exam visitee){
        System.out.printf("%-30s%-20s%-20s%", visitee.getExamTitle(), visitee.getExamCourse(), visitee.identity().getExamName());
    }
}
