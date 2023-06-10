package eCourse.domain;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class BoardUpdateEvent extends AbstractBoardUpdateEvent {

    @OneToMany//the relationship is controlled by the event
    private List<Notification> notifications = new ArrayList<>();


    @ManyToOne
    private SharedBoard board;

    public BoardUpdateEvent(final SharedBoard board) {
        super(board);
        createUpdateBoardNotification();
    }


    private void createUpdateBoardNotification() {
        Notification notification = new Notification(this);
        notifications.add(notification);
    }
}
