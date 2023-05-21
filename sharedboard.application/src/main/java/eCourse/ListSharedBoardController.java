package eCourse;

import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;

public class ListSharedBoardController {

    private ListSharedBoardService sharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> listBoardsByUser(){
        return sharedBoardService.listBoardsByUser();
    }

}

