package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.app.user.console.presentation.myuser.UserDataWidget;
//import eapli.base.course.application.CourseEnrollmentRequestController;
import eapli.framework.presentation.console.AbstractUI;

public class CourseEnrollmentRequestUI extends AbstractUI {

    /*
    private final CourseEnrollmentRequestController theController = new CourseEnrollmentRequestController();


     */

    @Override
    protected boolean doShow() {
        final var userData = new UserDataWidget();
        userData.show();

        return false;
    }

    @Override
    public String headline() { return "Request Course Enrollment";}

}
