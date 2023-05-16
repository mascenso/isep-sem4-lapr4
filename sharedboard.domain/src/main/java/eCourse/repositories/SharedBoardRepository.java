package eCourse.repositories;

import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardTitle;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface SharedBoardRepository extends DomainRepository<SharedBoardTitle, SharedBoard> {

    Iterable<SharedBoard> findByUsername(final Username name);
}
