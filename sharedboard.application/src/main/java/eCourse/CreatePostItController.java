package eCourse;

import eCourse.domain.Position;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardCell;
import eCourse.domain.SharedBoardUser;
import eCourse.domain.postit.PostIt;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.SharedBoardCellRepository;
import eCourse.repositories.SharedBoardRepository;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.apache.commons.io.IOUtils;
import shareboardTCPServer.SBPClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CreatePostItController {

    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();
    SharedBoardRepository repository = PersistenceContext.repositories().sharedBoards();
    SharedBoardCellRepository repoCell = PersistenceContext.repositories().sharedBoardCells();
    SharedBoardUserRepository repoUsers = PersistenceContext.repositories().sharedBoardUser();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public Iterable<SharedBoard> listBoardsByUser() throws IOException {
        return listSharedBoardService.listBoardsByUser();
    }

    public Iterable<SharedBoardCell> listFreeCells(SharedBoard sb) {
        return listSharedBoardService.listFreeCells(sb);
    }


    public SharedBoard registerPostIt(final SharedBoard shBoard, Integer x, Integer y, final String name) throws IOException {

        /* Retrieves the sharedBoardUser */
        Optional<Username> username = authz.session().map(s -> s.authenticatedUser().identity());
        List<SharedBoardUser> sharedBoardUser = repoUsers.findListUser(shBoard.boardTitle(), username.get());

        shBoard.addPostItToCell(new PostIt(name), Position.valueOf(x, y), sharedBoardUser.get(0));
        //make a request to save board
        SBPClient.saveBoard(shBoard);
        SBPClient.ReadDataOfMessage();
        return repository.save(shBoard);
    }

    public SharedBoard registerPostIt(final SharedBoard shBoard, Integer x, Integer y, final String name,
                                         final InputStream imageStream) throws IOException {

        Optional<Username> username = authz.session().map(s -> s.authenticatedUser().identity());
        List<SharedBoardUser> sharedBoardUser = repoUsers.findListUser(shBoard.boardTitle(), username.get());

        final PostIt newPostIt = new PostIt(name);
        if (imageStream != null) {
            newPostIt.changeImage(IOUtils.toByteArray(imageStream));
        }

        shBoard.addPostItToCell(newPostIt, Position.valueOf(x, y), sharedBoardUser.get(0));
        //make a request to save board
        SBPClient.saveBoard(shBoard);
        SBPClient.ReadDataOfMessage();
        return repository.save(shBoard);
    }

    public SharedBoardCell registerPostIt(final SharedBoardCell shBoard, final String name) throws IOException {

        /* Retrieves the sharedBoardUser */
        Optional<Username> username = authz.session().map(s -> s.authenticatedUser().identity());
        List<SharedBoardUser> sharedBoardUser = repoUsers.findListUser(shBoard.boardTitle(), username.get());

        shBoard.addPostIt(new PostIt(name), sharedBoardUser.get(0));
        return repoCell.save(shBoard);
    }

    public SharedBoardCell registerPostIt(final SharedBoardCell shBoard, final String name,
                                      final InputStream imageStream) throws IOException {

        Optional<Username> username = authz.session().map(s -> s.authenticatedUser().identity());
        List<SharedBoardUser> sharedBoardUser = repoUsers.findListUser(shBoard.boardTitle(), username.get());

        final PostIt newPostIt = new PostIt(name);
        if (imageStream != null) {
            newPostIt.changeImage(IOUtils.toByteArray(imageStream));
        }

        shBoard.addPostIt(newPostIt, sharedBoardUser.get(0));
        return repoCell.save(shBoard);
    }
}
