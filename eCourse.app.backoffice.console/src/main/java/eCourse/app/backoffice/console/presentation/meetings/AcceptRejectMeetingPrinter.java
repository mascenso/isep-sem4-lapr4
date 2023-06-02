package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.domain.ParticipantsOfMeeting;
import eapli.framework.visitor.Visitor;

public class AcceptRejectMeetingPrinter implements Visitor<ParticipantsOfMeeting> {
    @Override
    public void visit(ParticipantsOfMeeting visitee) {
        System.out.println(" TO DO");
    }
}
