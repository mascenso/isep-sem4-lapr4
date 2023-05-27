package eCourse.domain;

import eCourse.MechanographicNumber;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class StudentBuilder implements DomainFactory<Student> {

    private Student theStudent;

    private MechanographicNumber mechanographicNumber;

    private SystemUser systemUser;

    public StudentBuilder mechanographicNumber(final MechanographicNumber mechanographicNumber) {
        this.mechanographicNumber = mechanographicNumber;
        return this;
    }

    public StudentBuilder systemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    private Student buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theStudent != null) {
            return theStudent;
        }
        if (systemUser != null && mechanographicNumber != null) {
            theStudent = new Student(systemUser, mechanographicNumber);
            return theStudent;
        }
        throw new IllegalStateException();

    }

    @Override
    public Student build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theStudent = null;
        return ret;
    }
}

