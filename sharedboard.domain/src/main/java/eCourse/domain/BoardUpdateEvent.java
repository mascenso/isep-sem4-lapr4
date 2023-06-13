package eCourse.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class BoardUpdateEvent extends AbstractBoardUpdateEvent {

    @OneToMany//the relationship is controlled by the event
    private List<Notification> notifications = new ArrayList<>();


    @ManyToOne
    private SharedBoard board;

    public BoardUpdateEvent(final SharedBoard board, final SystemUser user) {
        super(board);
        createUpdateBoardNotification(user);
    }

    public BoardUpdateEvent(){

    }

    private void createUpdateBoardNotification(SystemUser user) {
        Notification notification = new Notification(this, user);
        notifications.add(notification);
    }
}
