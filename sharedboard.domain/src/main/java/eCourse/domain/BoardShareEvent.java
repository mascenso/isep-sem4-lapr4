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

    @ManyToOne
    private SharedBoard board;

    // for ORM
    protected BoardShareEvent() {
        super();
    }


    public BoardShareEvent(final SharedBoardUser what) {
        super(what);
        createNotification();
    }

    public BoardShareEvent(final SharedBoard board) {
        super(board);
        createNotification();
    }

    private void createNotification() {
        Notification notification = new Notification(this);
        notifications.add(notification);
    }

}
