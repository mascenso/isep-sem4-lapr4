package eapli.base;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ListSharedBoardController {

    SharedBoardRepository sharedBoardRepository;
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();
    private SessionBuilder<SessionBuilder> sessionFactory;

    public List<SharedBoard> getAllSharedBoards() {
        try (Session session = sessionFactory.openSession()) {
            Query<SharedBoard> query = session.createQuery("FROM SharedBoard", SharedBoard.class);
            return query.getResultList();
        }
    }

    public Iterable<SharedBoard> listBoardsByUser() {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        Iterable<SharedBoard> boardIterable = PersistenceContext.repositories().sharedBoards().findByUsername(user.get().identity());
        List<SharedBoard> boardListByUser = IteratorUtils.toList(boardIterable.iterator());

        /*for (Board board : boardListByUser) {
            System.out.println(board.getTitle());
            System.out.println(board.getOwner().username());
        }*/

        return boardListByUser;
    }
}

