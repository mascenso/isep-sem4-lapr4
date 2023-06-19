package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.client.SharedBoardDTO;
import eCourse.domain.SharedBoard;
import eapli.framework.visitor.Visitor;

public class SharedBoardDTOPrinter implements Visitor<SharedBoardDTO> {
    @Override
    public void visit(final SharedBoardDTO visitee){
        System.out.printf("%-30s%-20s%-20s%-20s%-20s", visitee.shBoardtitle, visitee.row, visitee.col, visitee.owner, visitee.archive);
    }
}

