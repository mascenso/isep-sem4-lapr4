package eCourse.domain;

import eCourse.domain.enums.AccessType;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SharedBoardUser implements AggregateRoot<SharedBoardTitle> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    //@JoinColumn(nullable = false, name = "User ID")
    private SystemUser user;

    @Column(nullable = false, name = "Title")
    private SharedBoardTitle title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessType permission;

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<AbstractBoardShareEvent> events = new HashSet<>();

    protected SharedBoardUser(SystemUser user, SharedBoardTitle boardID, AccessType access) {
        Preconditions.noneNull(user, boardID, access);

        this.user = user;
        title = boardID;
        permission = access;

        final var shared = new BoardShareEvent(this);
        events.add(shared);
    }

    protected SharedBoardUser() {
    }

    public static SharedBoardUser valueOf(SystemUser user, SharedBoardTitle boardID, eCourse.domain.enums.AccessType access) {
        Preconditions.noneNull(user, "The User cannot be empty");
        Preconditions.noneNull(boardID, "The boardID cannot be empty");
        Preconditions.noneNull(access, "The Access cannot be empty");
        return new SharedBoardUser(user, boardID, access);
    }

    public SharedBoardTitle hasTitle() {
        return title;
    }

    public eCourse.domain.enums.AccessType withPermission() {
        return permission;
    }

    public SystemUser boardUser() {
        return user;
    }

    public Set<AbstractBoardShareEvent> events() {
        return events;
    }

    @Override
    public boolean sameAs(Object other) {

        if (this == other) {
            return true;
        }

        if (!(other instanceof SharedBoardUser)) {
            return false;
        }

        final SharedBoardUser otherSharedBoardUser = (SharedBoardUser) other;

        return user.equals(otherSharedBoardUser.user)
                && title.equals(otherSharedBoardUser.title)
                && permission.equals(otherSharedBoardUser.permission);
    }

    public AccessType hasPermission() {
        return permission;
    }

    @Override
    public SharedBoardTitle identity() {
        return title;
    }
}
