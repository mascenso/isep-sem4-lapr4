package eapli.base;

import eapli.base.domain.SharedBoard;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.SharedBoardRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;

import java.util.List;
import java.util.Optional;

public class ListSharedBoardController {

    private ListSharedBoardService sharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> listBoardsByUser(){
        return sharedBoardService.listBoardsByUser();
    }

    /*SharedBoardRepository sharedBoardRepository;
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    private

    public Iterable<SharedBoard> listBoardsByUser() {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<SharedBoard> boardIterable = PersistenceContext.repositories().sharedBoards().findByUsername(user.get().identity());
        List<SharedBoard> boardListByUser = IteratorUtils.toList(boardIterable.iterator());

        return boardListByUser;
    }*/
}

