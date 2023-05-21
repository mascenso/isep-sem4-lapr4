package eCourse.app.student.console.presentation.meetings;

import eCourse.application.ScheduleMeetingController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ScheduleMeetingsUI extends AbstractUI {

    private final ScheduleMeetingController theController = new ScheduleMeetingController();
    @Override
    protected boolean doShow() {
        final String name = Console.readNonEmptyLine("Name for meeting","The name should not be empty");
        //This fetches all users of the application
        final Iterable<SystemUser> allUsers= theController.allUsers();
        final List<SystemUser> participants = showAllUsersTOChooseParticipants(allUsers);
        boolean validSchedule = false;
        Date dateOfSchedule = null;
        int duration = 0;

        //It will ask for the time until a time that works for all participants is introduced
        do {
            dateOfSchedule = Console.readDate("Date for meeting (dd/MM/yyyy HH:mm)", "dd/MM/yyyy HH:mm");
             duration = Console.readInteger("Insert the duration of meeting (on minuts)");
            validSchedule = theController.validateSchedule(participants, dateOfSchedule, duration);

            if(!validSchedule){
                System.out.println("==========================================================================");
                System.out.println("The chosen time matches the time of a meeting of one of the participants.");
                System.out.println("Please choose another time.");
                System.out.println("==========================================================================");
            }
        }while(validSchedule==false);

        theController.scheduleMeeting(name,participants,dateOfSchedule,duration);
        return false;
    }

    private List<SystemUser> showAllUsersTOChooseParticipants(Iterable<SystemUser> allUsers) {
        //copy of list
        List<SystemUser> users = new ArrayList<>();
        for (SystemUser user : allUsers) {
            users.add(user);
        }
        //selected users
        List<SystemUser> selectedUsers = new ArrayList<>();

        //Scanner to read option from user
        Scanner scanner = new Scanner(System.in);

        //show a list of users and ask to choose participants
        while (!users.isEmpty()) {
            System.out.println("Select participant or 0 to exit:");
            int index = 1;
            for (SystemUser user : users) {
                System.out.println(index + ". " + user.name());
                index++;
            }
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice > 0 && choice <= users.size()) {
                SystemUser selectedUser = users.remove(choice - 1);
                selectedUsers.add(selectedUser);
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }

        return selectedUsers;
    }

    @Override
    public String headline() {
        return "Schedule new meeting";
    }
}
