package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Calendar;

public class CourseEnrollmentRequestBuilder implements DomainFactory<CourseEnrollmentRequest>  {

    private CourseEnrollmentRequest theCourseEnrollmentRequest;

    private Username username;

    private Designation name;

    private EmailAddress email;

    private ApprovalStatus approvalStatus;

    private Calendar createdOn;

    private Designation courseName;

    private CourseEdition edition;

    private CourseState courseState;



    public CourseEnrollmentRequestBuilder named(final Designation name){
        this.name = name;
        return this;
    }

    public CourseEnrollmentRequestBuilder withData(final Username username,
            final EmailAddress email) {
        this.username = username;
        this.email = email;
        return this;
    }

    public CourseEnrollmentRequestBuilder approved(final ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }

    public CourseEnrollmentRequestBuilder created(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public CourseEnrollmentRequestBuilder courseNamed(final Designation courseName) {
        this.courseName = courseName;
        return this;
    }

    public CourseEnrollmentRequestBuilder edition(final CourseEdition edition) {
        this.edition = edition;
        return this;
    }

    public CourseEnrollmentRequestBuilder state(final CourseState courseState) {
        this.courseState = courseState;
        return this;
    }


    private CourseEnrollmentRequest buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theCourseEnrollmentRequest != null) {
            return theCourseEnrollmentRequest;
        }
        if (username != null && name != null && email != null && approvalStatus != null && courseName != null && edition != null ) {
            createdOn = CurrentTimeCalendars.now();
            theCourseEnrollmentRequest = new CourseEnrollmentRequest(username, name, email, approvalStatus, createdOn, courseName, edition, courseState);
            return theCourseEnrollmentRequest;
        }
        throw new IllegalStateException();

    }

    @Override
    public CourseEnrollmentRequest build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theCourseEnrollmentRequest = null;
        return ret;
    }
}
