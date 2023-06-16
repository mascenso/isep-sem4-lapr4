package eCourse.repositories;

import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedBoardUserRepository extends DomainRepository<SharedBoardTitle, SharedBoardUser> {

    Iterable<SharedBoardUser> findByUser(final Username user);

    Iterable<SharedBoardUser> findUsersBySharedBoard(final SharedBoardTitle title);
}
