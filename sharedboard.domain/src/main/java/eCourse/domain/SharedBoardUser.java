package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SharedBoardUser implements AggregateRoot<SharedBoardTitle> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private SystemUser user;

    @Column(unique = true)
    private SharedBoardTitle title;

    @Column(nullable = false, name = "Permission")
    @Enumerated(EnumType.STRING)
    private AccessType permission;

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<AbstractBoardShareEvent> events = new HashSet<>();

    protected SharedBoardUser(SystemUser user, SharedBoardTitle boardID, AccessType access){
        this.user=user;
        title=boardID;
        permission=access;

        final var shared = new BoardShareEvent(this);
        events.add(shared);
    }

    protected SharedBoardUser(){
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

    @Override
    public SharedBoardTitle identity() {
        return title;
    }
}
