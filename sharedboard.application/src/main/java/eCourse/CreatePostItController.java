package eCourse;

import eCourse.domain.SharedBoard;
import eCourse.domain.postit.PostIt;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.SharedBoardRepository;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class CreatePostItController {

    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();
    SharedBoardRepository repository = PersistenceContext.repositories().sharedBoards();


    public Iterable<SharedBoard> allSharedBoards() {
        return listSharedBoardService.listBoardsByUser();
    }

    public PostIt registerPostIt(final String name,
                                 final InputStream imageStream) throws IOException {
        return doRegisterPostIt(name, imageStream);
    }

    private PostIt doRegisterPostIt(final String name,
                                        final InputStream imageStream) throws IOException {

        final PostIt newPostIt = new PostIt();
        if (imageStream != null) {
            newPostIt.changeImage(IOUtils.toByteArray(imageStream));
        }

        return newPostIt;
    }


}
