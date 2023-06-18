package eCourse.app.teacher.console.presentation.exam;

import eCourse.app.common.console.ExamPrinter;
import eCourse.app.teacher.console.presentation.Courses.CoursesPrinter;
import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.exam.application.ListExamsCourseController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.stereotype.Component;

@Component
public class ListExamsCourseUI extends AbstractUI {

    private final ListExamsCourseController theController = new ListExamsCourseController();

    @Override
    public String headline() {
        return "List Courses";
    }

    protected String listHeader() {
        return String.format("#  %-30s%-20s%-20s%-30s%-20s", "Course", "Title", "Teacher", "Open Date", "Close Date");
    }

    @Override
    public boolean doShow() {

        final Iterable<Course> allCoursesOpen = theController.allCoursesInProgress();

        if (!allCoursesOpen.iterator().hasNext()) {
            System.out.println("There are no registered Courses");
        }
        else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select a course", allCoursesOpen, new CoursesPrinter());
            selector.show();
            final Course selCourse = selector.selectedElement();

            final Iterable<Exam> examElements = theController.listExamsByCourse(selCourse);

            if (!examElements.iterator().hasNext()) {
                System.out.println("There are no registered Exams");
            }
            else {
                new ListWidget(this.listHeader(), examElements, new ExamPrinter()).show();
            }
        }

        return true;
    }
}