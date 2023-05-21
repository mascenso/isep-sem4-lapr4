package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CourseEnrollmentRequest implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EnrollmentID;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private SystemUser student;

    @OneToMany
    @JoinColumn(name = "courseEnrollmentRequest")
    private List<ListEnrollmentRequests> enrollmentRequestsList;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus enrollmentStatus;

    @Column
    //date on format dd/mm/yyyy hh:mm
    private Calendar createdOn;

    public CourseEnrollmentRequest(Course course, SystemUser student, List<SystemUser> listOfCourseRequests){

        this.enrollmentStatus = EnrollmentStatus.PENDING;
        this.createdOn = CurrentTimeCalendars.now();
        this.enrollmentStatus = EnrollmentStatus.PENDING;

        this.enrollmentRequestsList = new ArrayList<>();
        this.enrollmentRequestsList.add(new ListEnrollmentRequests(this, course, student));

    }

    public CourseEnrollmentRequest() {
    }

    public List<ListEnrollmentRequests> enrollmentRequests(){return this.enrollmentRequestsList;}


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
