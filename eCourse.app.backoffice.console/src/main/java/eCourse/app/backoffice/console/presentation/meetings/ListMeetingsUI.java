package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.application.ListMeetingsController;
import eCourse.domain.Meeting;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListMeetingsUI extends AbstractListUI<Meeting> {

    private ListMeetingsController listMeetingsController = new ListMeetingsController();

    @Override
    protected Iterable<Meeting> elements() {
        return listMeetingsController.listMeetingsByUser();
    }

    @Override
    protected Visitor<Meeting> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return "Meeting";
    }

    @Override
    protected String listHeader() {
        return null;
    }

    @Override
    protected String emptyMessage() {
        return "No Meetings";
    }

    @Override
    public String headline() {
        return "List Meetings";
    }
}
