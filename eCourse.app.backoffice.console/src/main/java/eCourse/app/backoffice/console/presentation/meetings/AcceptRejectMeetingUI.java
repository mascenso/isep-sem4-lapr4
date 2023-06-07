package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.application.AcceptRejectMeetingController;
import eCourse.application.ParticipantMeetingService;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.domain.ParticipantsStatus;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AcceptRejectMeetingUI extends AbstractUI {
    private AcceptRejectMeetingController acceptRejectMeetingController = new AcceptRejectMeetingController();
    private ParticipantMeetingService participantMeetingService = new ParticipantMeetingService();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Override
    protected boolean doShow() {

        final Iterable<ParticipantsOfMeeting> myMeetings = acceptRejectMeetingController.listMeetingsByUser();
        final ParticipantsOfMeeting meetingSelected = showMyMeetings(myMeetings);

        if (meetingSelected != null) {
            System.out.println("Meeting: " + meetingSelected.meeting().designation());
            System.out.println("Current Status: " + meetingSelected.participantStatus().toString());

            String currentStatus = meetingSelected.participantStatus().toString();
            ParticipantsStatus newStatus = null;

            do {
                newStatus = showParticipantStatus(ParticipantsStatus.valueOf(currentStatus));
            }   while (newStatus == null);

            if (newStatus != ParticipantsStatus.valueOf(currentStatus)){
                if (newStatus == ParticipantsStatus.ACCEPT) {
                    acceptRejectMeetingController.acceptMeetingRequest(meetingSelected, newStatus);
                } else if (newStatus == ParticipantsStatus.REJECTED) {
                    acceptRejectMeetingController.rejectMeetingRequest(meetingSelected, newStatus);
                }
            }
            return true;
        } else {
            System.out.println("Meeting not found");
            return false;
        }
    }

    private ParticipantsOfMeeting showMyMeetings(Iterable<ParticipantsOfMeeting> myMeetings){
        List<ParticipantsOfMeeting> meetings = new ArrayList<>();
        for (ParticipantsOfMeeting meeting : myMeetings){
            if (meeting.participantStatus() == ParticipantsStatus.PENDING) {
                meetings.add(meeting);
            }
        }
        Scanner sc = new Scanner(System.in);

        // show a list of my meetings
        System.out.println("Select a meeting or 0 to exit:");
        int index = 1;
        for (ParticipantsOfMeeting meeting : meetings) {
            System.out.println(index + ". " + meeting.meeting().designation());
            index++;
        }
        int choice = sc.nextInt();
        if (choice > 0 && choice <= meetings.size()){
            return meetings.get(choice-1);
        } else {
            System.out.println("Invalid selection. Try again");
        }
        return null;
    }

    private ParticipantsStatus showParticipantStatus(ParticipantsStatus currentStatus){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. ACCEPT");
        System.out.println("2. REJECT");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        ParticipantsStatus newStatus = null;

        switch (opcao) {
            case 1:
                newStatus = ParticipantsStatus.ACCEPT;
                break;
            case 2:
                newStatus = ParticipantsStatus.REJECTED;
                break;
            default:
                System.out.println("Invalid Option");
               
        }

        if (newStatus != null){
            if (newStatus != currentStatus){
                return newStatus;
            } else  {
                System.out.println("The new status is the same of the current state");
            }
        }
        return null;
    }

    @Override
    public String headline() {
        return "Accept or Reject Meeting Requests";
    }
}