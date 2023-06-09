package eCourse.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


public class BoardShareEvent extends AbstractBoardShareEvent {

    /* Herda o ID do AbstractBoardShareEvent!!! */


    @OneToMany//the relationship is controlled by the event
    private List<Notification> notifications = new ArrayList<>();

    @ManyToOne
    private SharedBoardUser what;

    // for ORM
    protected BoardShareEvent() {
        super();
    }


    public BoardShareEvent(final SharedBoardUser what) {
        super(what);
        createNotification();
    }

    private void createNotification() {
        Notification notification = new Notification(this);
        notifications.add(notification);
    }

}
