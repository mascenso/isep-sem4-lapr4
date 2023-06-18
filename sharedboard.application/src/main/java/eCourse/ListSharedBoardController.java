package eCourse;

import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;

import java.io.IOException;

public class ListSharedBoardController {

    private ListSharedBoardService sharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> listBoardsByUser() throws IOException {

        return sharedBoardService.listBoardsByUser();
    }

}

