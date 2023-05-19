package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.security.core.userdetails.User;

public class CourseEnrollmentRequest implements AggregateRoot<Course> {
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public SystemUser identity() {
        return null;
    }
}
