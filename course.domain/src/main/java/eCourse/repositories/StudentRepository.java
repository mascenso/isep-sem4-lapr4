package eCourse.repositories;

import eCourse.MechanographicNumber;
import eCourse.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public interface StudentRepository
        extends DomainRepository<MechanographicNumber, Student> {

    Optional<Student> findByUsername(Username name);

    default Optional<Student> findByMechanographicNumber(final MechanographicNumber number) {
        return ofIdentity(number);
    }

    public Iterable<Student> findAllActive();

}