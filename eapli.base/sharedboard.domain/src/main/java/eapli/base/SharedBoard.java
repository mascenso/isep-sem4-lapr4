package eapli.base;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

@Entity
public class SharedBoard implements AggregateRoot<SharedBoardTitle> {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoard;

    @EmbeddedId
    private SharedBoardTitle title;

    @OneToOne()
    private SystemUser owner;

    @Column
    private boolean archive;

    public SharedBoard(){


    }
    public SharedBoard(final SharedBoardTitle title, boolean archive, final SystemUser owner) {
        if (title == null || owner == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.owner = owner;
    }

    public SharedBoardTitle getTitle(){
        return title;
    }

    public SystemUser getOwner(){
        return this.owner;
    }

    public boolean getArchive(){
        return archive;
    }

    public void updateArchive(boolean archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public SharedBoardTitle boardTitle() {
        return identity();
    }

    @Override
    public SharedBoardTitle identity() {
        return this.title;
    }

    public boolean isArchive(){
        return true;
    }
}
