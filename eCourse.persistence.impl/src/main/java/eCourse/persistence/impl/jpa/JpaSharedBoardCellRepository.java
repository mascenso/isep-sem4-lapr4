package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.SharedBoardCell;
import eCourse.repositories.SharedBoardCellRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaSharedBoardCellRepository extends JpaAutoTxRepository<SharedBoardCell, String, String> implements SharedBoardCellRepository {
    public JpaSharedBoardCellRepository(final TransactionalContext autoTx) {
        super(autoTx, "index");
    }

    public JpaSharedBoardCellRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "titleOfBoardTile");
    }

}
