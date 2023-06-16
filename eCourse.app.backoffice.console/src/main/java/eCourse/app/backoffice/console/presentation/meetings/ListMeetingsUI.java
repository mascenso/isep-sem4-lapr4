package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.application.ListMeetingsController;
import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMeetingsUI extends AbstractUI {

    private final ListMeetingsController listMeetingsController = new ListMeetingsController();
    @Override
    protected boolean doShow() {
        final Iterable<Meeting> myMeetings = listMeetingsController.listMeetingsByUser();
        final Meeting meetingSelected = showMyMeetings(myMeetings);

        if (meetingSelected != null) {
            System.out.println("Meeting: " + meetingSelected.designation().toString());
            showParticipants(meetingSelected);
        }
        return false;
    }

    private Meeting showMyMeetings(Iterable<Meeting> myMeetings) {
        List<Meeting> meetingList = new ArrayList<>();
        for (Meeting meeting : myMeetings) {
            meetingList.add(meeting);
        }
        Scanner sc = new Scanner(System.in);

        // show list of meetings
        System.out.println("Select Meeting or 0 to exit");
        int index = 1;
        for (Meeting meeting : meetingList){
            System.out.println(index + ". " + meeting.designation());
            index++;
        }
        int choice = sc.nextInt();
        if (choice > 0 && choice <= meetingList.size()){
            return meetingList.get(choice-1);
        } else {
            System.out.println("Invalid selection. Try again");
        }
        return null;
    }

    private ParticipantsOfMeeting showParticipants (Meeting meetingSelected){
        Iterable<ParticipantsOfMeeting> participants = listMeetingsController.participantsByMeeting(meetingSelected);

        if (participants == null){
            System.out.println("No participants");
            return null;
        }
        System.out.println("Participants: ");
        for (ParticipantsOfMeeting participant : participants) {
            System.out.println( participant.identity() + "              "
                                    + participant.participantStatus());
        }
        return null;


    }

    @Override
    public String headline() {
        return "List Meeting and Participants";
    }

    /*private ListMeetingsController listMeetingsController = new ListMeetingsController();

    @Override
    protected Iterable<Meeting> elements() {
        return listMeetingsController.listMeetingsByUser();
    }

    @Override
    protected Visitor<Meeting> elementPrinter() {
        return new ListMeetingsPrinter();
    }

    @Override
    protected String elementName() {
        return "Meeting";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-25s%-20s%-20s", "Designation", "Date", "Owner", "Status");
    }

    @Override
    protected String emptyMessage() {
        return "No Meetings";
    }

    @Override
    public String headline() {
        return "List Meetings";
    }*/
}
