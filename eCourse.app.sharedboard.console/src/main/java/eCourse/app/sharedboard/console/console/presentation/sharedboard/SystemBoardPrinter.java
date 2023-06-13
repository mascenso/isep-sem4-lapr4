package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.domain.SharedBoard;
import eapli.framework.visitor.Visitor;

public class SystemBoardPrinter implements Visitor<SharedBoard> {
    @Override
    public void visit(final SharedBoard visitee){
        System.out.printf("%-30s%-20s%-20s%-20s%-20s", visitee.title(), visitee.colunas().size(), visitee.linhas().size(), visitee.owner().username().toString(), visitee.archive());
    }
}

