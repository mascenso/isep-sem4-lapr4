package eCourse.persistence.impl.jpa;

import eCourse.domain.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eCourse.repositories.NotificationRepository;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class JpaSharedBoardUserRepository implements SharedBoardUserRepository {
    public JpaSharedBoardUserRepository(String persistenceUnitName) {
    }

    @Override
    public Iterable<SharedBoardUser> findByUser(SystemUser user) {
        return null;
    }

    @Override
    public <S extends SharedBoardUser> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<SharedBoardUser> findAll() {
        return null;
    }

    @Override
    public Optional<SharedBoardUser> ofIdentity(SharedBoardTitle id) {
        return Optional.empty();
    }

    @Override
    public void delete(SharedBoardUser entity) {

    }

    @Override
    public void deleteOfIdentity(SharedBoardTitle entityId) {

    }

    @Override
    public long count() {
        return 0;
    }
}
