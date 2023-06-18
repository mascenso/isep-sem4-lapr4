package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.domain.SharedBoard;
import eCourse.domain.SharedBoardCell;
import eapli.framework.visitor.Visitor;

public class CellPrinter implements Visitor<SharedBoardCell> {
    @Override
    public void visit(final SharedBoardCell visitee){
        System.out.printf(visitee.toString());
    }
}

