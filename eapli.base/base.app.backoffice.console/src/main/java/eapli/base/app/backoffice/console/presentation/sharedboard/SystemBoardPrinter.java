package eapli.base.app.backoffice.console.presentation.sharedboard;

import eapli.base.domain.SharedBoard;
import eapli.framework.visitor.Visitor;

public class SystemBoardPrinter implements Visitor<SharedBoard> {
    @Override
    public void visit(final SharedBoard visitee){
        System.out.printf("%-30s%-20s%-20s%-20s%-20s", visitee.getTitle(), visitee.getColunas().size(), visitee.getLinhas().size(), visitee.getOwner().username().toString(), visitee.getArchive());
    }
}

