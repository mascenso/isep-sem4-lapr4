package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Teacher;
import eCourse.repositories.TeacherRepository;
import eCourse.domain.Acronym;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JpaTeacherRepository
        extends JpaAutoTxRepository<Teacher, Acronym, Acronym>
        implements TeacherRepository {


    public JpaTeacherRepository(final TransactionalContext autoTx) {
        super(autoTx, "acronym");
    }

    public JpaTeacherRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "acronym");
    }

    @Override
    public Optional<Teacher> findByUsername(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<Teacher> findByAcronym(final Acronym acronym) {
        final Map<String, Object> params = new HashMap<>();
        params.put("acronym", acronym);
        return matchOne("e.acronym=:acronym", params);
    }

    @Override
    public Iterable<Teacher> findAllActive() {
        return match("e.systemUser.active = true");
    }
}
