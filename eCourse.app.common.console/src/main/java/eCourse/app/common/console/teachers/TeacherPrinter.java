package eCourse.app.common.console.teachers;

import eCourse.domain.Teacher;
import eapli.framework.visitor.Visitor;

public class TeacherPrinter implements  Visitor<Teacher> {
    @Override
    public void visit(final Teacher visitee) {
        System.out.printf("%-39s", visitee.acronym());
    }
}
