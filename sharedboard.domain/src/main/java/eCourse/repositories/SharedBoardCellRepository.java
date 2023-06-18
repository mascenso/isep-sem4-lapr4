package eCourse.repositories;

import eCourse.domain.SharedBoardCell;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedBoardCellRepository extends DomainRepository<String, SharedBoardCell> {


    public Iterable<SharedBoardCell> findAll();

    Iterable<SharedBoardCell> ownedBy(Username systemUser);
}