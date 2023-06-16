package eCourse.app.backoffice.console.presentation.students;

import eCourse.application.CourseEnrollmentRequestService;
import eCourse.course.application.ApproveAndRejectEnrollmentsController;
import eCourse.course.application.ListCoursesService;
import eCourse.domain.Course;
import eCourse.domain.SharedBoard;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApproveAndRejectEnrollmentsUI extends AbstractUI {

    private ApproveAndRejectEnrollmentsController theController = new ApproveAndRejectEnrollmentsController();

    private ListCoursesService service = new ListCoursesService();

    private CourseEnrollmentRequestService enrollService = new CourseEnrollmentRequestService();

    @Override
    protected boolean doShow() {

        List<Course> enrollCourses = service.getEnrollmentCourses();
        final Map<Integer, Designation> courseMap = new HashMap<>();
        System.out.println("Select the Course:");

        int selectedOption = showInfo(enrollCourses, courseMap);
        final Course selectedCourse = enrollCourses.get(selectedOption - 1);

        //enrollService.validateCourseEnrollmentRequest();




        return false;
    }


    protected int showInfo(List<Course> courses, Map<Integer, Designation> map) {
        int index = 1;
        for (Course c : courses) {
            map.put(index, c.identity());
            System.out.println(index + ". " + c.identity());
            index++;
        }
        return Console.readOption(1, index - 1, 0);
    }

    @Override
    public String headline() {
        return "Approve or Reject Enrollments";
    }
}
