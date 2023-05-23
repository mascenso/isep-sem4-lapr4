package eCourse.domain;

import eCourse.MechanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student implements AggregateRoot<MechanographicNumber> {

    @EmbeddedId
    private MechanographicNumber mechanographicNumber;

    @OneToOne()
    private SystemUser systemUser;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public Student(final SystemUser user, final MechanographicNumber mechanographicNumber) {
        if (mechanographicNumber == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.mechanographicNumber = mechanographicNumber;
    }

    protected Student() {
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

    public MechanographicNumber mecanographicNumber() {
        return identity();
    }

    @Override
    public MechanographicNumber identity() {
        return this.mechanographicNumber;
    }

    public boolean addCourse(Course course) {
        return this.courses.add(course);
    }
}

