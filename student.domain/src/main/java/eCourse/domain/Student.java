package eCourse.domain;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

@Entity
public class Student implements AggregateRoot<MecanographicNumber> {

    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    // Business ID
    @Column(unique = true, nullable = false)
    private MecanographicNumber mecanographicNumber;

    //@Temporal(TemporalType.DATE)
    //Date dateOfBirth;

    // Business ID
    @Column(unique = true, nullable = false)
    @Embedded
    private TaxPayNumber taxPayNumber;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    public Student(final SystemUser user, final MecanographicNumber mecanographicNumber) {
        if (mecanographicNumber == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.mecanographicNumber = mecanographicNumber;
    }

    protected Student() {
        // for ORM only
    }

    public Student(SystemUser user, MecanographicNumber mecanographicNumber, TaxPayNumber taxPayNumber) {
        if (mecanographicNumber == null || user == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.mecanographicNumber = mecanographicNumber;
        this.taxPayNumber = taxPayNumber;
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

    public MecanographicNumber mecanographicNumber() {
        return identity();
    }

    @Override
    public MecanographicNumber identity() {
        return this.mecanographicNumber;
    }

    /*
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
     */


    /*
    public boolean addCourse(Course course) {
        return this.courses.add(course);
    }
     */
}
