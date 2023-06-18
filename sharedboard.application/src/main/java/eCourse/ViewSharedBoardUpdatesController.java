package eCourse;

import eCourse.domain.*;
import eCourse.domain.enums.AccessType;
import eCourse.domain.SBColumn;
import eCourse.domain.SBRow;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


@Component
@UseCaseController
public class ViewSharedBoardUpdatesController{

    @Autowired
    private ListSharedBoardService listSharedBoardService = new ListSharedBoardService();

    public Set<SharedBoard> listOfAllUserBoards(Map<SharedBoardTitle, AccessType> map) throws IOException {
        return listSharedBoardService.listOfAllUserBoards(map);
    }
}
