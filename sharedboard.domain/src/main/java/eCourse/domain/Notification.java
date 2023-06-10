package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;


@Entity
public class Notification implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private SystemUser user;

    private SharedBoardTitle title;

    private AccessType permission;

    private boolean archive;

    private int numberColumns;
    private int numberRows;

    @OneToMany
    private List<Coluna> colunas;

    @OneToMany
    private List<Linha> linhas;


    public Notification() {
    }

    public Notification(BoardShareEvent event) {
        Preconditions.noneNull(event);
        this.id = identity();
        this.user = event.what().boardUser();
        this.title = event.what().hasTitle();
        this.permission = event.what().withPermission();
    }

    public Notification(SharedBoard board) {
        Preconditions.noneNull(board);
        this.title = board.boardTitle();
        this.numberColumns = board.numberOfColumns();
        this.numberRows = board.numberOfRows();
        this.user = board.owner();
        this.archive = board.archive();
        this.colunas = board.colunas();
        this.linhas = board.linhas();
    }

    public Long id() {
        return id;
    }

    public SystemUser user() {
        return user;
    }

    public AccessType permission() {
        return permission;
    }

    public void setPermission(AccessType permission) {
        this.permission = permission;
    }

    public SharedBoardTitle title() {
        return title;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Notification)) {
            return false;
        }

        final Notification otherNotification = (Notification) other;

        return user.equals(otherNotification.user)
                && title.equals(otherNotification.title) ;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        if (permission != null) {
            return "You have been granted access to board " + title +
                    ", and you have " + permission + " permissions!";
        } else {
            return "The board " + title + " was updated!";
        }
    }
}
