package eCourse;

import eCourse.domain.Position;
import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardUser;
import eCourse.domain.postit.PostIt;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.SharedBoardRepository;
import eCourse.repositories.SharedBoardUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.apache.commons.io.IOUtils;
import shareboardHttpServer.SBPClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CreatePostItController {

    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();
    SharedBoardRepository repository = PersistenceContext.repositories().sharedBoards();
    SharedBoardUserRepository repoUsers = PersistenceContext.repositories().sharedBoardUser();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public Iterable<SharedBoard> allSharedBoards() throws IOException {
        return listSharedBoardService.listBoardsByUser();
    }


    public SharedBoard registerPostIt(final SharedBoard shBoard, Integer x, Integer y, final String name) throws IOException {

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
}
