package eCourse.app.backoffice.console.presentation.sharedboard;

import eCourse.ShareABoardController;
import eCourse.domain.*;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class ShareABoardUI extends AbstractUI {

    private ShareABoardController theController = new ShareABoardController();

    @Override
    protected boolean doShow() {

        Iterable<SharedBoard> myBoards = theController.getMyBoards();

        if (((Collection<?>) myBoards).size() == 0) {
            System.out.println("You have no Boards to share!");
            return false;
        }

        System.out.println("Which one you want to share? Press 0 to exit:");

        final Map<Integer, SharedBoardTitle> hashmap = new HashMap<>();
        int selectedOption = showInfo(myBoards, hashmap);

        SharedBoardTitle boardID = hashmap.get(selectedOption);

        Iterable<SystemUser> systemUsers = theController.allUsers();
        Map<Integer, AccessType> access =theController.getAccessTypes();

        Map<SystemUser,AccessType> usersWithPermissions=showAllUsers(systemUsers,access);

        theController.createShareBoardUsers(usersWithPermissions, boardID);

        return false;
    }


    protected int showInfo(Iterable<SharedBoard> myBoards, Map<Integer, SharedBoardTitle> map) {
        int index = 1;
        for (SharedBoard sb : myBoards) {
            map.put(index, sb.identity());
            System.out.println(index + ". " + sb.identity());
            index++;
        }
        int option = Console.readOption(1, index - 1, 0);
        return option;
    }



    private Map<SystemUser,AccessType> showAllUsers(Iterable<SystemUser> allUsers, Map<Integer, AccessType> permissions) {
        //copy of list
        List<SystemUser> users = new ArrayList<>();
        for (SystemUser user : allUsers) {
            users.add(user);
        }
        //selected users
        Map<SystemUser,AccessType> selectedUsers = new HashMap<>();

        //Scanner to read option from user
        Scanner scanner = new Scanner(System.in);

        //show a list of users and ask to choose users
        while (!users.isEmpty()) {
            System.out.println("Select Users or 0 to exit:");
            int index = 1;
            for (SystemUser user : users) {
                System.out.println(index + ". " + user.name());
                index++;
            }
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Select the Access Type or 0 to exit:");
            for (Map.Entry<Integer,AccessType> ac: permissions.entrySet()){
                System.out.println(ac.getKey() + ". " + ac.getValue());
            }

            int option = Console.readOption(1, index - 1, 0);

            if (choice > 0 && choice <= users.size()) {
                SystemUser selectedUser = users.remove(choice - 1);
                selectedUsers.put(selectedUser,permissions.get(option));
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }

        return selectedUsers;
    }


    @Override
    public String headline() {
        return "Share a Board";
    }
}
