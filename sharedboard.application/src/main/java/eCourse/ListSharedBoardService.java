package eCourse;

import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardUser;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@ApplicationService
public class ListSharedBoardService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<SharedBoard> listBoardsByUser() {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<SharedBoard> boardIterable = PersistenceContext.repositories().sharedBoards().findByUsername(user.get().identity());
        List<SharedBoard> boardListByUser = IteratorUtils.toList(boardIterable.iterator());

        return boardListByUser;

    }


    public Iterable<SharedBoard> listBoardsSharedWithUser() {
        List<SharedBoard> list = new ArrayList<>();
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<SharedBoardUser> boardIterable = PersistenceContext.repositories().sharedBoardUser().findByUser(user.get());
        List<SharedBoardUser> sharedBoardListWithUser = IteratorUtils.toList(boardIterable.iterator());
        for (SharedBoardUser sb : sharedBoardListWithUser) {
            SharedBoard board = (SharedBoard) PersistenceContext.repositories().sharedBoards().findBoardByTitle(sb.hasTitle());
            list.add(board);
        }

        return list;
    }


    public Iterable<SharedBoard> listOfAllUserBoards() {
        List<SharedBoard> list = new ArrayList<>();
        Iterable<SharedBoard> boardsOwned = listBoardsByUser();
        Iterable<SharedBoard> sharedBoards = listBoardsSharedWithUser();

        for (SharedBoard board : boardsOwned) {
            list.add(board);
        }

        // Adiciona os elementos do segundo iterador (sharedBoards)
        for (SharedBoard board : sharedBoards) {
            list.add(board);
        }

        return list;
    }
}
