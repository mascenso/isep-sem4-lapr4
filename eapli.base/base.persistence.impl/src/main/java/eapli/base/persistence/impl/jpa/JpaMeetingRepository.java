package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.Course;
import eapli.base.domain.CourseEdition;
import eapli.base.domain.Meeting;
import eapli.base.repositories.MeetingsRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Date;
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
    public Optional<Meeting> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {

    }
}
