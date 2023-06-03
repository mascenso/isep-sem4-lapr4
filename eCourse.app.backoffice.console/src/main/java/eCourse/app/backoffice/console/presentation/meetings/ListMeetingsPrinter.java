package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.domain.Meeting;
import eapli.framework.visitor.Visitor;

public class ListMeetingsPrinter implements Visitor<Meeting> {
    @Override
    public void visit(Meeting visitee) {
        System.out.printf("%-30s%-25s%-20s%-20s", visitee.designation(), visitee.dateOfMeeting(), visitee.meetingCreator().username().toString(), visitee.meetingStatus());
    }
}
