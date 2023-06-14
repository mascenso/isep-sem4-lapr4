package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

@Entity
public class Teacher implements AggregateRoot<Acronym> {
    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    // Business ID
    @Column(unique = true, nullable = false)
    @Embedded
    private Acronym acronym;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    public Teacher(final SystemUser user, final String acronym) {
        if (acronym == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.acronym = new Acronym(acronym);
    }

    protected Teacher() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
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
