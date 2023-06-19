package eCourse;

import eCourse.client.CsvBookingProtocolProxy;
import eCourse.client.FailedRequestException;
import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;

import java.io.IOException;

public class ListSharedBoardController {

    private ListSharedBoardService sharedBoardService = new ListSharedBoardService();

    public Iterable<SharedBoard> listBoardsByUser() throws IOException, FailedRequestException {
        return sharedBoardService.listBoardsByUser("poweruser");
    }

}

