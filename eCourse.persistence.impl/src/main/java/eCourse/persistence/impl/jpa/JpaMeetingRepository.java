package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.repositories.MeetingsRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaMeetingRepository extends JpaAutoTxRepository<Meeting, String,String>
        implements MeetingsRepository {


    public JpaMeetingRepository(TransactionalContext tx) {
        super(tx, "Meeting repository");
    }

    public JpaMeetingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "MeetingName");
    }


    @Override
    public Optional<Meeting> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public Iterable<Meeting> findByUsername(Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.owner.username=:name", params);
    }

}
