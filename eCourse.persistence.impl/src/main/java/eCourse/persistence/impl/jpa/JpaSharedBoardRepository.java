package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.SharedBoard;
import eCourse.repositories.SharedBoardRepository;
import eCourse.domain.SharedBoardTitle;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;

public class JpaSharedBoardRepository extends JpaAutoTxRepository<SharedBoard, SharedBoardTitle, SharedBoardTitle> implements SharedBoardRepository {
    public JpaSharedBoardRepository(final TransactionalContext autoTx) {
        super(autoTx, "titleOfBoardTile");
    }

    public JpaSharedBoardRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "titleOfBoardTile");
    }

    @Override
    public Iterable<SharedBoard> findByUsername(Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.owner.username=:name", params);
    }


    @Override
    public Iterable<SharedBoard> findBoardByTitle(SharedBoardTitle name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.title=:name", params);
    }
}
