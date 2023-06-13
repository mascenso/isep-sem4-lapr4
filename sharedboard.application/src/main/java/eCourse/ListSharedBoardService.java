package eCourse;

import eCourse.domain.AccessType;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardTitle;
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
import java.util.Map;
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


    public Iterable<SharedBoard> listBoardsSharedWithUser(Map<SharedBoardTitle, AccessType> map) {
        List<SharedBoard> list = new ArrayList<>();
        Iterable<SharedBoard> board = null;
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<SharedBoardUser> boardIterable = PersistenceContext.repositories().sharedBoardUser().findByUser(user.get().identity());
        List<SharedBoardUser> sharedBoardListWithUser = IteratorUtils.toList(boardIterable.iterator());
        if (sharedBoardListWithUser.size() == 0) {
            return list;
        }
        for (SharedBoardUser sb : sharedBoardListWithUser) {
            board = PersistenceContext.repositories().sharedBoards().findBoardByTitle(sb.hasTitle());
            map.put(sb.hasTitle(),sb.hasPermission());
        }
        return IteratorUtils.toList(board.iterator());

    }


    public Iterable<SharedBoard> listOfAllUserBoards(Map<SharedBoardTitle, AccessType> map) {
        List<SharedBoard> list = new ArrayList<>();
        Iterable<SharedBoard> boardsOwned = listBoardsByUser();
        Iterable<SharedBoard> sharedBoards = listBoardsSharedWithUser(map);

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
