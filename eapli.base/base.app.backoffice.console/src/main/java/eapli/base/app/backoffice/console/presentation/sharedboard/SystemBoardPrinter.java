package eapli.base.app.backoffice.console.presentation.sharedboard;

import eapli.base.SharedBoard;
import eapli.framework.visitor.Visitor;

public class SystemBoardPrinter implements Visitor<SharedBoard> {
    @Override
    public void visit(final SharedBoard visitee){
        System.out.printf("%-10s%-30s%-30s", visitee.getTitle(), visitee.getOwner(), visitee.getArchive());
    }
}

