package eCourse.app.teacher.console.presentation.Courses;

import eCourse.course.application.ListCoursesStudentController;
import eCourse.course.application.ListCoursesTeacherController;
import eCourse.domain.Course;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import org.springframework.stereotype.Component;

@Component
public class ListCoursesTeacherUI extends AbstractListUI<Course> {

    private ListCoursesTeacherController theController = new ListCoursesTeacherController();

    protected Iterable<Course> elements() {
        return theController.allCoursesOpen();
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
        return String.format("# %-40s%-20s%-40s%-4s", "NAME", "EDITION", "DESCRIPTION", "STATE");
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
