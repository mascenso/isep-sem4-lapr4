package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Meeting;
import eCourse.repositories.MeetingsRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

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
}
