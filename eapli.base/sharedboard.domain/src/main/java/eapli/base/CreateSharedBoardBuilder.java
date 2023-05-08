package eapli.base;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CreateSharedBoardBuilder implements DomainFactory<SharedBoard> {


    private SharedBoardTitle title;

    private boolean archive;

    private SystemUser owner;

    public CreateSharedBoardBuilder withTile(final String title) {
        this.title = new SharedBoardTitle(title);
        return this;
    }

    public CreateSharedBoardBuilder withArchive(boolean archive){
        this.archive = archive;
        return this;
    }

    public CreateSharedBoardBuilder withOwner(final SystemUser owner) {
        this.owner = owner;
        return this;
    }


    @Override
    public SharedBoard build() {
        return new SharedBoard(this.title, this.archive, this.owner);

    }


}
