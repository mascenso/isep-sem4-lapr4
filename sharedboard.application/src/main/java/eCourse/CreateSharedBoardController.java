package eCourse;

import eCourse.domain.*;
import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.infrastructure.persistence.RepositoryFactory;
import eCourse.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
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

    public void addSharedBoard(String title, int numberOfColumns, int numberOfrows, List<SBColumn> columnNames, List<SBRow> rowNames) throws IntegrityViolationException, ConcurrencyException {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.ADMIN, ECourseRoles.MANAGER, ECourseRoles.PROJECT_MANAGER, ECourseRoles.TEACHER, ECourseRoles.STUDENT, ECourseRoles.POWER_USER);

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
