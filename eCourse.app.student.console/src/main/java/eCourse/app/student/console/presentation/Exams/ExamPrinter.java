package eCourse.app.student.console.presentation.Exams;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<Exam> {
    @Override
    public void visit(final Exam visitee) {
        System.out.printf("%-30s%-20s%-20s%-10s%-20s%n", visitee.getExamTitle(), visitee.getExamCourse().identity().toString(), visitee.identity().getExamName(), visitee.getExamGrade().getGrade(),  visitee.getExamGrade().getStudent());
    }
}
