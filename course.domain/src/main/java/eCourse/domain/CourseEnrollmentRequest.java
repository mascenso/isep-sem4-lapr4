package eCourse.domain;

import eCourse.domain.CourseEdition;
import eCourse.domain.CourseState;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Calendar;

public class CourseEnrollmentRequest implements AggregateRoot<Username> {

    @EmbeddedId
    private Username userName;

    @Embedded
    private Designation name;

    @Embedded
    private EmailAddress email;

    @Column(nullable = false)
    private ApprovalStatus approvalStatus;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar createdOn;

    @Embedded
    private Designation courseName;

    @Embedded
    private CourseEdition edition;

    @Embedded
    private CourseState courseState;

    protected CourseEnrollmentRequest (final Username userName, final Designation name, final EmailAddress email,
                                       final ApprovalStatus approvalStatus, final Calendar createdOn, final Designation courseName, final CourseEdition edition,
                                       final CourseState courseState){
        Preconditions.noneNull(userName, name, email, approvalStatus, createdOn, courseName, edition, courseState);

        this.userName = userName;
        this.name = name;
        this.email = email;
        this.approvalStatus = approvalStatus;
        this.courseName = courseName;
        this.createdOn = createdOn;
        this.edition = edition;
        this.courseState= courseState;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Username identity() {
        return null;
    }
}
