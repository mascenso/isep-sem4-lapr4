package eCourse;

import eCourse.domain.*;
import eCourse.domain.SBColumn;
import eCourse.domain.SBRow;
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
import shareboardHttpServer.SBPClient;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@UseCaseController
public class CreateSharedBoardController {

    Integer maxColumnsSharedBoard = Application.settings().getMaxColumnsSharedBoard();
    Integer maxRowsSharedBoard = Application.settings().getMaxRowsSharedBoard();

    private final RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    private final TransactionalContext tx = repositoryFactory.newTransactionalContext();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();


    public void addSharedBoard(String title, int numberOfColumns, int numberOfrows, List<SBColumn> columnNames, List<SBRow> rowNames) throws IntegrityViolationException, ConcurrencyException, IOException {
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

        //request to tcp server
        SBPClient.saveBoard(createdSharedBoard);
        SBPClient.ReadDataOfMessage();
        PersistenceContext.repositories().sharedBoards().save(createdSharedBoard);


    }

}
