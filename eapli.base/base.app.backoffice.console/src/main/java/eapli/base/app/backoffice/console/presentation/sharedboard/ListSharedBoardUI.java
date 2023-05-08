package eapli.base.app.backoffice.console.presentation.sharedboard;

import eapli.base.ListSharedBoardController;
import eapli.base.SharedBoard;
import eapli.base.SharedBoardRepository;
import eapli.base.SharedBoardTitle;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

import java.util.List;
import java.util.Optional;

public class ListSharedBoardUI extends AbstractListUI {

    private final ListSharedBoardController listSharedBoardController = new ListSharedBoardController();


    @Override
    public String headline() {
        return "List SharedBoards";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }


    @Override
    protected Iterable<SharedBoard> elements() {
        return listSharedBoardController.listBoardsByUser();

    }

    @Override
    protected Visitor<SharedBoard> elementPrinter() {
        return new SystemBoardPrinter();
    }

    @Override
    protected String elementName() {
        return "Board";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-50s%-30s%-30s", "Title", "Owner", "Archive");
    }




}
