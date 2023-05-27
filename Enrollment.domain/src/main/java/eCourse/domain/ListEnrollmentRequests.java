/*package eCourse.domain;

import eCourse.MechanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;

public class ListEnrollmentRequests implements AggregateRoot<CourseEnrollmentRequest> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentRequestID;

    @ManyToOne
    @JoinColumn(name = "course_enrollment_request_id")
    private CourseEnrollmentRequest courseEnrollmentRequest;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus enrollmentStatus;

    public ListEnrollmentRequests(CourseEnrollmentRequest courseEnrollmentRequest, Course course, Student student) {
        this.courseEnrollmentRequest = courseEnrollmentRequest;
        this.course = course;
        this.student = student;
        this.enrollmentStatus = enrollmentStatus.PENDING;
    }

    public ListEnrollmentRequests() {

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.enrollmentRequestID;
    }
}

 */
