package eCourse.app.teacher.console.presentation.sharedBoard;

import eCourse.NotificationController;
import eCourse.domain.Notification;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class NotificationUI extends AbstractUI {

    private NotificationController theController = new NotificationController();

    @Override
    protected boolean doShow() {

        List<Notification> myNotifications = theController.getMyNotifications();

        if (myNotifications.size() == 0) {
            System.out.println("You have no notifications!");
            return false;
        }

        for (Notification notif: myNotifications){
            System.out.println(notif.toString());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Notification";
    }
}
