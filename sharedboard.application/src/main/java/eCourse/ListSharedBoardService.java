package eCourse;

import eCourse.domain.SharedBoardCell;
import eCourse.domain.enums.AccessType;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.domain.SharedBoardUser;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;
import shareboardTCPServer.SBPClient;

import java.io.IOException;
import java.util.*;

@Component
@ApplicationService
public class ListSharedBoardService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<SharedBoard> listBoardsByUser() throws IOException {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        SBPClient.findAllBoardsByUser(user.get().identity());
        SBPClient.ReadDataOfMessage();
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
            map.put(sb.hasTitle(), sb.hasPermission());
        }
        return IteratorUtils.toList(board.iterator());

    }


    public Set<SharedBoard> listOfAllUserBoards(Map<SharedBoardTitle, AccessType> map) throws IOException {
        Iterable<SharedBoard> boardsOwned = listBoardsByUser();
        Iterable<SharedBoard> sharedBoards = listBoardsSharedWithUser(map);

        Set<SharedBoard> uniqueBoards = new HashSet<>();

        for (SharedBoard board : boardsOwned) {
            uniqueBoards.add(board);
        }

        // Adiciona os elementos do segundo iterador (sharedBoards)
        for (SharedBoard board : sharedBoards) {
            uniqueBoards.add(board);
        }

        return uniqueBoards;
    }

    public Iterable<SystemUser> getUsersWithSharedBoard(SharedBoard board) {
        Iterable<SharedBoardUser> allBoardUsers = PersistenceContext.repositories().sharedBoardUser().findUsersBySharedBoard(board.title());
        List<SharedBoardUser> users = IteratorUtils.toList(allBoardUsers.iterator());
        List<SystemUser> usersList = new ArrayList<>();
        for (SharedBoardUser user : users) {
            usersList.add(user.boardUser());
        }
        return usersList;
    }

    public Iterable<SharedBoardCell> listFreeCells(SharedBoard sb) {
        return PersistenceContext.repositories().sharedBoardCells().findFreeCells(sb.title());
    }

}