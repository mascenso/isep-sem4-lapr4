package eCourse.domain;

import eCourse.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends ECourseUser implements AggregateRoot<Acronym> {
    private static final long serialVersionUID = 1L;


    // Business ID
    @Column(unique = true, nullable = false)
    @Embedded
    private Acronym acronym;

    public Teacher(SystemUser systemUser, final String acronym) {
        super(systemUser);
        if (acronym == null) {
            throw new IllegalArgumentException();
        }
        this.acronym = new Acronym(acronym);
    }

    protected Teacher() {
        // for ORM only
    }

    public SystemUser systemUser() {
        return super.systemUser;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Acronym acronym() {
        return identity();
    }

    @Override
    public Acronym identity() {
        return this.acronym;
    }

}
