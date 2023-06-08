package eCourse;

import eCourse.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationController {

    @Autowired
    private ListNotificationsService notificationsService = new ListNotificationsService();

    public List<Notification> getMyNotifications() {
        return notificationsService.getMyNotifications();
    }
}
