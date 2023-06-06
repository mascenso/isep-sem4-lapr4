package eCourse.repositories;

import eCourse.domain.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public interface SharedBoardsUsersRepository extends DomainRepository<SharedBoardTitle, SharedBoardUser> {

    Iterable<SharedBoardUser> findByUser(final SystemUser user);
}