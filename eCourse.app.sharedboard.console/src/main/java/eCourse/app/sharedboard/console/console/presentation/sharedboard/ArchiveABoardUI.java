package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.ArchiveABoardController;
import eCourse.client.FailedRequestException;
import eCourse.domain.SharedBoard;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.*;

public class ArchiveABoardUI extends AbstractUI {

    private final ArchiveABoardController theController = new ArchiveABoardController();
    private static final AuthorizationService authz = AuthzRegistry.authorizationService();


    @Override
    protected boolean doShow() {

        List<SharedBoard> myBoards = null;
        try {
            myBoards = (List<SharedBoard>) theController.listBoardsByUser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FailedRequestException e) {
            throw new RuntimeException(e);
        }

        if (((Collection<?>) myBoards).size() == 0) {
            System.out.println("You have no Boards!");
            return false;
        }

        final Map<Integer, SharedBoard> boards = new HashMap<>();
        System.out.println("Which one you want to Archive? Press 0 to exit:");

        int selectedOption = showInfo(myBoards, boards);
        SharedBoard board = boards.get(selectedOption);

        authz.session().map(s -> s.authenticatedUser().identity());
        Optional<SystemUser> user = authz.session().map(UserSession::authenticatedUser);

        if (!board.archive()) {
            boolean isOwner = theController.changeArchive(board, user.get());
            if (isOwner) {
                theController.archiveBoard(board, user.get());
            } else {
                System.out.println("Only the board's owner has permissions to archive it!");
            }
        } else {
            System.out.println("It already was archived!");
        }
        return false;
    }


    protected int showInfo(List<SharedBoard> myBoards, Map<Integer, SharedBoard> map) {
        int index = 1;
        for (SharedBoard sb : myBoards) {
            map.put(index, sb);
            System.out.println(index + ". " + sb.identity());
            index++;
        }
        return Console.readOption(1, index - 1, 0);
    }


    @Override
    public String headline() {
        return "Archive Board";
    }
}
