package eCourse.app.student.console.presentation.Courses;

import eCourse.course.application.ListCoursesStudentController;
import eCourse.domain.Course;
import eCourse.myclientuser.application.RequestEnrollmentController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestEnrollmentCoursesStudentUI extends AbstractUI  {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestEnrollmentCoursesStudentUI.class);
    private ListCoursesStudentController listController = new ListCoursesStudentController();
    private RequestEnrollmentController theController = new RequestEnrollmentController();



    @Override
    public String headline() {
        return "List Courses";
    }

    @Override
    public boolean doShow() {

        final Iterable<Course> allCoursesOpen = listController.allCoursesOpen();
        if (!allCoursesOpen.iterator().hasNext()) {
            System.out.println("There are no registered Courses");
        }
        else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select a course", allCoursesOpen, new CoursesPrinter());
            selector.show();

            //todo: Use DTO
            final Course selCourse = selector.selectedElement();

            try {
                this.theController.requestEnrollment(selCourse);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                LOGGER.error("Error performing the operation", e);
                System.out.println(
                        "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
            }

        return true;
    }
}
