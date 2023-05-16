package eapli.base;

import eapli.base.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@UseCaseController
public class CreateSharedBoardController {
    private final RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    private final TransactionalContext tx = repositoryFactory.newTransactionalContext();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public static void addSharedBoard(String title, int numberOfColumns, int numberOfrows, List<Coluna> columnNames, List<Linha> rowNames) throws IntegrityViolationException, ConcurrencyException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.MANAGER, BaseRoles.PROJECT_MANAGER, BaseRoles.TEACHER, BaseRoles.STUDENT);

        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);
        SharedBoard createdSharedBoard = new CreateSharedBoardBuilder()
                .withTile(title)
                .withNumberOfColumns(numberOfColumns)
                .withNumberOfRows(numberOfrows)
                .withArchive(false)
                .withOwner(user.get())
                .withColumns(columnNames)
                .withRows(rowNames)
                .build();
        PersistenceContext.repositories().sharedBoards().save(createdSharedBoard);
    }

}
