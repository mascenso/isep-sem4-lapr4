package eapli.base.app.backoffice.console.presentation.sharedboard;

import eapli.base.ListSharedBoardController;
import eapli.base.domain.SharedBoard;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

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
        return String.format("#  %-30s%-20s%-20s%-20s%-20s", "Title", "NumberColumns", "NumberRows", "Owner", "Archive");
    }




}
