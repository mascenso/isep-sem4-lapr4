package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;
import java.util.List;

public class CourseEnrollmentRequestBuilder implements DomainFactory<CourseEnrollmentRequest> {

    private CourseEnrollmentRequest theCourseEnrollmentRequest;

    private Long theEnrollmentID;

    private Course theCourse;

    private Student theStudent;

    //private List<CourseEnrollmentRequest> theEnrollmentRequestsList;



    private EnrollmentStatus theEnrollmentStatus;

    private Calendar theCreatedOn;

    public CourseEnrollmentRequestBuilder theCourse(final Course course) {
        this.theCourse = course;
        return this;
    }

    public CourseEnrollmentRequestBuilder theStudent(final Student student) {
        this.theStudent = student;
        return this;
    }

    /*
    public CourseEnrollmentRequestBuilder theEnrollmentRequestList(final List<CourseEnrollmentRequest> enrollmentRequestsList) {
        this.theEnrollmentRequestsList = enrollmentRequestsList;
        return this;
    }

     */

    public CourseEnrollmentRequestBuilder theEnrollmentStatus(final EnrollmentStatus enrollmentStatus) {
        this.theEnrollmentStatus = enrollmentStatus;
        return this;
    }

    private CourseEnrollmentRequest buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theCourseEnrollmentRequest != null) {
            return theCourseEnrollmentRequest;
        }

        if (theCourse != null && theStudent != null) {
            theCourseEnrollmentRequest = new CourseEnrollmentRequest(theCourse, theStudent);
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
