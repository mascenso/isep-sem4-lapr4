package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
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
    public Iterable<SharedBoardUser> findByUser(Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.user.username=:name", params);
    }

    @Override
    public Iterable<SharedBoardUser> findUsersBySharedBoard(SharedBoardTitle name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.title=:name", params);
    }

    @Override
    public Optional<SharedBoardUser> findUser(SharedBoardTitle name, Username username) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        return matchOne("e.title=:name AND e.user.username=:username", params);
    }

    @Override
    public Optional<SharedBoardUser> ofIdentity(SharedBoardTitle id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(SharedBoardTitle entityId) {

    }
}
