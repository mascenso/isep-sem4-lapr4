package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Meeting;
import eCourse.domain.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eCourse.repositories.NotificationRepository;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaSharedBoardUserRepository extends JpaAutoTxRepository<SharedBoardUser, String,String>
        implements SharedBoardUserRepository {


    public JpaSharedBoardUserRepository(TransactionalContext tx) {
        super(tx, "ShareBoardUSer Repository");
    }
    public JpaSharedBoardUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "ShareBoardUSer Name");
    }

    @Override
    public Iterable<SharedBoardUser> findByUser(SystemUser user) {
        return null;
    }

    @Override
    public Optional<SharedBoardUser> ofIdentity(SharedBoardTitle id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(SharedBoardTitle entityId) {

    }
}
