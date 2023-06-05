package eCourse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BoardShareEvent extends AbstractBoardShareEvent {

    @OneToMany(mappedBy = "event") //the relationship is controlled by the event
    private List<Notification> notifications = new ArrayList<>();

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
