package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;
import java.util.Calendar;

public class CourseEnrollmentRequest {

    /*
    @Version
    private Long version;

    @EmbeddedId
    private Username username;

    private Name name;

    private EmailAddress email;

    private MecanographicNumber mecanographicNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalStatus approvalStatus;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar createdOn;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Username identity() {
        return null;
    }

     */


}
