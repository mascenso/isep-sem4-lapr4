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

    public SharedBoard registerPostIt(final SharedBoard shBoard, final String name,
                                 final InputStream imageStream) throws IOException {
        return doRegisterPostIt(shBoard, name, imageStream);
    }

    private SharedBoard doRegisterPostIt(final SharedBoard shBoard, final String name,
                                        final InputStream imageStream) throws IOException {

        final PostIt newPostIt = new PostIt(name);
        if (imageStream != null) {
            newPostIt.changeImage(IOUtils.toByteArray(imageStream));
        }

        shBoard.addPostItToCell(newPostIt, 0,0);

        return repository.save(shBoard);
    }


}
