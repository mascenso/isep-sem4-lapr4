package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.ListSharedBoardController;
import eCourse.domain.SharedBoard;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.io.IOException;

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
        try {
            return listSharedBoardController.listBoardsByUser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
