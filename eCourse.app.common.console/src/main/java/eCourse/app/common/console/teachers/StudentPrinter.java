package eCourse.app.common.console.teachers;

import eCourse.domain.Student;
import eCourse.domain.Teacher;
import eapli.framework.visitor.Visitor;

public class StudentPrinter implements  Visitor<Student> {
    @Override
    public void visit(final Student visitee) {
        System.out.printf("%-39s", visitee.mecanographicNumber());
    }
}
