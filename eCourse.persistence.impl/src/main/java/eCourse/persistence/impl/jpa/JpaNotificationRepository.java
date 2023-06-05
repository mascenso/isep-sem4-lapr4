package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Notification;
import eCourse.domain.SharedBoardUser;
import eCourse.repositories.NotificationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaNotificationRepository extends JpaAutoTxRepository<Notification, String,String>
        implements NotificationRepository {

    public JpaNotificationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "Notification name");
    }
    public JpaNotificationRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, "Notification repository");
    }

    @Override
    public Iterable<Notification> findByUser(SystemUser user) {
        return null;
    }

    @Override
    public Optional<Notification> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}
