package eCourse.app.backoffice.console.presentation.meetings;

import eCourse.application.CancelMeetingController;
import eCourse.domain.Meeting;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Scanner;

public class CancelMeetingUI extends AbstractUI {

    private CancelMeetingController theController = new CancelMeetingController();

    @Override
    protected boolean doShow() {

        List<Meeting> listMeetings = theController.ListMeetingsOfUSer();
        int selectedOption = -1;
        //Scanner to read option from user
        Scanner scanner = new Scanner(System.in);
        if(listMeetings.isEmpty()){
            System.out.println("============================================");
            System.out.println("Dont exist meeting Schedule created for you.");
            System.out.println("============================================");
        }else {
            do {
                System.out.println("Please select the meeting.");
                for (int i = 0; i < listMeetings.size(); i++) {
                    System.out.printf("(%d) %s\n", i, listMeetings.get(i).designation().toString());
                }

                selectedOption = scanner.nextInt();

                if (selectedOption < 0 || selectedOption > listMeetings.size()) {
                    System.out.println("============================");
                    System.out.println("Please select a valid option");
                    System.out.println("============================");
                }

            } while ((selectedOption < 0 || selectedOption > listMeetings.size()) && !listMeetings.isEmpty());
            if (!listMeetings.isEmpty()) {
                theController.cancelMeeting(listMeetings.get(selectedOption));
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Meeting";
    }
}
