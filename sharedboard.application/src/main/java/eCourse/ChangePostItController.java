package eCourse;

import eCourse.domain.Position;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardCell;
import eCourse.domain.SharedBoardUser;
import eCourse.domain.postit.PostIt;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.SharedBoardCellRepository;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class ChangePostItController {

    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();
    private SharedBoardUserRepository repoUser = PersistenceContext.repositories().sharedBoardUser();
    SharedBoardCellRepository repo = PersistenceContext.repositories().sharedBoardCells();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<SharedBoard> allSharedBoards() {
        return listSharedBoardService.listBoardsByUser();
    }

    public Iterable<SharedBoardCell> ownedSharedBoardCells() {
        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);

        Iterable<SharedBoardUser> user1 = repoUser.findByUser(user.get().username());

        return repo.ownedBy(user.get().username());
    }

    public SharedBoard changeAPostIt(final SharedBoard shBoard, Position pos, final String name,
                                     final InputStream imageStream) throws IOException {
        return doChangePostIt(shBoard, pos, name, imageStream);
    }

    private SharedBoard doChangePostIt(final SharedBoard shBoard, Position pos, final String name,
                                       final InputStream imageStream) throws IOException {

        final PostIt newPostIt = new PostIt(name);
        if (imageStream != null) {
            newPostIt.changeImage(IOUtils.toByteArray(imageStream));
        }

        //shBoard.addPostItToCell(newPostIt, pos);

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void changePost(SharedBoardCell theCell, String newContent) {

    }

    public void movePost(SharedBoardCell theCell, SharedBoardCell newCell) {
    }

    public Iterable<SharedBoardCell> freeSharedBoardCells() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showCellContent(SharedBoardCell theCell) {
    }
}
