package eCourse.app.backoffice.console.presentation.courses;

import eCourse.course.application.ListCoursesController;
import eCourse.domain.Course;
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
        return String.format("# %-40s%-20s%-40s%-20s%-20s", "NAME", "EDITION", "DESCRIPTION", "STATE", "COORDINATOR");
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
