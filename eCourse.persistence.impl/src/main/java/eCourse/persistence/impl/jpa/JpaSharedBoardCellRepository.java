package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.SharedBoardCell;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.repositories.SharedBoardCellRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaSharedBoardCellRepository extends JpaAutoTxRepository<SharedBoardCell, String, String> implements SharedBoardCellRepository {
    public JpaSharedBoardCellRepository(final TransactionalContext autoTx) {
        super(autoTx, "index");
    }

    public JpaSharedBoardCellRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "titleOfBoardTile");
    }

    @Override
    public Iterable<SharedBoardCell> ownedBy(Username name) {
        final TypedQuery<SharedBoardCell> query = entityManager().createQuery(
                "SELECT e FROM SharedBoardCell e WHERE e.owner.user.username = :name", SharedBoardCell.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<SharedBoardCell> findFreeCells(SharedBoardTitle title) {
            //find all cells that have the title and the state is free
            final TypedQuery<SharedBoardCell> query = entityManager().createQuery(
                    "SELECT e FROM SharedBoardCell e WHERE e.sharedboard.title = :title AND e.state = 'EMPTY'", SharedBoardCell.class);
            query.setParameter("title", title);
            return query.getResultList();
    }

}
