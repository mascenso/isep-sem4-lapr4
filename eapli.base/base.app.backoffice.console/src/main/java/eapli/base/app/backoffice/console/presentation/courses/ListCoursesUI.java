package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.ListCoursesController;
import eapli.base.domain.Course;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import org.springframework.stereotype.Component;

@Component
public class ListCoursesUI extends AbstractListUI<Course> {

    private ListCoursesController theController = new ListCoursesController();

    protected Iterable<Course> elements() {
        return theController.allCourses();
    }

    @Override
    protected Visitor<Course> elementPrinter() {
        return new CoursesPrinter();
    }

    @Override
    protected String elementName() {
        return "Course";
    }

    @Override
    public String listHeader() {
        return String.format("# %-20s%-20s%-20s%-4s", "NAME", "EDITION", "DESCRIPTION", "STATE");
    }

    @Override
    protected String emptyMessage() {
        return "No courses";
    }


    @Override
    public String headline() {
        return "List Courses";
    }

}
