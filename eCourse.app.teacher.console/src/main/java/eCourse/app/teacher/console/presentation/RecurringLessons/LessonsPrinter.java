package eCourse.app.teacher.console.presentation.RecurringLessons;

import eCourse.domain.Course;
import eCourse.lesson.domain.model.RecurringLesson;
import eapli.framework.visitor.Visitor;

public class LessonsPrinter implements  Visitor<RecurringLesson> {
    @Override
    public void visit(final RecurringLesson visitee) {
        System.out.printf("%-39s", visitee.identity());
    }
}
