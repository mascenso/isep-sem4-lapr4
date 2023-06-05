package eCourse.persistence.impl.jpa;

import eCourse.domain.Notification;
import eCourse.repositories.NotificationRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class JpaNotificationRepository implements NotificationRepository {


    public JpaNotificationRepository(String persistenceUnitName) {
    }

    @Override
    public Iterable<Notification> findByUser(SystemUser user) {
        return null;
    }

    @Override
    public <S extends Notification> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<Notification> findAll() {
        return null;
    }

    @Override
    public Optional<Notification> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Notification entity) {

    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public long count() {
        return 0;
    }
}
