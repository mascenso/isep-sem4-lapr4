package eCourse.app.teacher.console.presentation.Courses;

import eCourse.domain.Course;
import eapli.framework.visitor.Visitor;

public class CoursesPrinter implements  Visitor<Course> {
    @Override
    public void visit(final Course visitee) {
        System.out.printf("%-39s%-20s%-40s%-4s", visitee.designation(), visitee.edition(),
                visitee.description(), visitee.state());
    }
}
