package eCourse.app.student.console.presentation.Courses;

import eCourse.application.CourseEnrollmentRequestController;
import eCourse.course.application.ListCoursesStudentController;
import eCourse.domain.Course;
import eapli.framework.actions.Action;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;
import org.springframework.stereotype.Component;

@Component
public class RequestEnrollmentCoursesStudentUI extends AbstractListUI<Course> implements Action {

    private ListCoursesStudentController listController = new ListCoursesStudentController();

    private CourseEnrollmentRequestController courseEnrollmentRequestController = new CourseEnrollmentRequestController();


    protected Iterable<Course> elements() {
        return listController.allCoursesOpen();
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

    @Override
    public boolean execute() {
        new ListCoursesStudentUI().show();

        final Iterable<Course> allCoursesEnrollment = listController.allCoursesEnrollment();
        if (!allCoursesEnrollment.iterator().hasNext()) {
            System.out.println("There are no Courses open for enrollment.");
        }
        else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select a course", allCoursesEnrollment, new CoursesPrinter());
            selector.show();
            final Course selCourse = selector.selectedElement();
            courseEnrollmentRequestController.courseEnrollment(selCourse);

            //try
            //theController.changeDishState(updtDish);
            }

        return true;
    }
}
