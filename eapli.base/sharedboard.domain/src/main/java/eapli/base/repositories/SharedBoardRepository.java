package eapli.base.repositories;

import eapli.base.domain.SharedBoard;
import eapli.base.domain.SharedBoardTitle;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface SharedBoardRepository extends DomainRepository<SharedBoardTitle, SharedBoard> {

    Iterable<SharedBoard> findByUsername(final Username name);
}
