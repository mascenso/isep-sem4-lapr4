package eCourse;

import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;

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

