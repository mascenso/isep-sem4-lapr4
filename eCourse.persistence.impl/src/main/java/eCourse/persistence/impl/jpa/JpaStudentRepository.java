package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.MechanographicNumber;
import eCourse.domain.Student;
import eCourse.domain.StudentBuilder;
import eCourse.repositories.StudentRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaStudentRepository extends JpaAutoTxRepository<Student, MechanographicNumber, MechanographicNumber>
        implements StudentRepository {

    public JpaStudentRepository(final TransactionalContext autoTx) {
        super(autoTx, "mechanographicNumber");
    }

    public JpaStudentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mechanographicNumber");
    }

    @Override
    public Optional<Student> findByUsername(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<Student> findByMechanographicNumber(final MechanographicNumber number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.mechanographicNumber=:number", params);
    }

    @Override
    public Iterable<Student> findAllActive() {
        return match("e.systemUser.active = true");
    }



}
