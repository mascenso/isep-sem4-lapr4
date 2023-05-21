package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.teacherusermanagement.domain.TeacherUser;
import eCourse.teacherusermanagement.repositories.TeacherUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JpaTeacherUserRepository
        extends JpaAutoTxRepository<TeacherUser, String, String>
        implements TeacherUserRepository {


    public JpaTeacherUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "acronym");
    }

    public JpaTeacherUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "acronym");
    }

    @Override
    public Optional<TeacherUser> findByUsername(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<TeacherUser> findByAcronym(final String acronym) {
        final Map<String, Object> params = new HashMap<>();
        params.put("acronym", acronym);
        return matchOne("e.acronym=:number", params);
    }

    @Override
    public Iterable<TeacherUser> findAllActive() {
        return match("e.systemUser.active = true");
    }
}
