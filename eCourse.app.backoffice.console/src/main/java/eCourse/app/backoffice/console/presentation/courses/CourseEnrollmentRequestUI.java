package eCourse.app.backoffice.console.presentation.courses;

import eCourse.domain.ApprovalStatus;
import eCourse.domain.CourseEdition;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


public class CourseEnrollmentRequestUI extends AbstractUI {

    private final CourseEnrollmentRequestController theController = new CourseEnrollmentRequestController();

    @Override
    protected boolean doShow() {
        final Username username = Username.valueOf(Console.readNonEmptyLine("Username","The UserName should not be empty"));
        final Designation name = Designation.valueOf(Console.readNonEmptyLine("First Name","The first Name should not be empty"));
        final EmailAddress email = EmailAddress.valueOf(Console.readNonEmptyLine("email","The email should not be empty"));
        final ApprovalStatus approvalStatus = ApprovalStatus.PENDING;
        final Designation courseName = Designation.valueOf(Console.readNonEmptyLine("course Name","The course name should not be empty"));
        final CourseEdition courseEdition = CourseEdition.valueOf(Console.readNonEmptyLine("course edition", "The course edition should not be empty"));
        try {
            this.theController.courseEnrollment(username, name, email, approvalStatus, null, courseName, courseEdition, null);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Create a new Course Enrollment Request";
    }
}
