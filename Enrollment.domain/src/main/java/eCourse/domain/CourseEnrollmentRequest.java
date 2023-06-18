package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Calendar;


@Entity
public class CourseEnrollmentRequest implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EnrollmentID;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    /*
    @OneToMany
    @JoinColumn(name = "courseEnrollmentRequest")
    private List<ListEnrollmentRequests> enrollmentRequestsList;


     */

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus enrollmentStatus;

    @Column
    //date on format dd/mm/yyyy hh:mm
    private Calendar createdOn;

    public CourseEnrollmentRequest(Course course, Student student) {//List<CourseEnrollmentRequest> listOfCourseRequests){
        Preconditions.noneNull(course, student);
        this.course = course;
        this.student = student;
        this.enrollmentStatus = EnrollmentStatus.PENDING;
        this.createdOn = CurrentTimeCalendars.now();

        //this.enrollmentRequestsList = new ArrayList<>();
        //this.enrollmentRequestsList.add(new ListEnrollmentRequests(this, course, student));

    }

    public CourseEnrollmentRequest() {
    }

    //public List<ListEnrollmentRequests> enrollmentRequests(){return this.enrollmentRequestsList;}


    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof CourseEnrollmentRequest)) {
            return false;
        }

        final CourseEnrollmentRequest otherCourseEnrollmentRequest = (CourseEnrollmentRequest) other;

        return course.equals(otherCourseEnrollmentRequest.course)
                && student.equals(otherCourseEnrollmentRequest.student)
                && enrollmentStatus.equals(otherCourseEnrollmentRequest.enrollmentStatus)
                && createdOn.equals(otherCourseEnrollmentRequest.createdOn);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public Long identity() {
        return EnrollmentID;
    }

    public Course courseEnrollmentRequestCourse() { return course; }

    public Student courseEnrollmentRequestStudent() { return student; }

    public EnrollmentStatus courseEnrollmentStatus() {return enrollmentStatus;}

    public void approveEnrollment(Student student) {
        this.enrollmentStatus = EnrollmentStatus.ACCEPTED;
        course.studentsEnrolled(student);
    }

    public void rejectEnrollment(Student student) {
        this.enrollmentStatus = EnrollmentStatus.REJECTED;
    }
}
