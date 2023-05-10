package eapli.base.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class CreateSharedBoardBuilder implements DomainFactory<SharedBoard> {


    private SharedBoardTitle title;

    private SharedBoardColumnAndRow position;

    private boolean archive;

    private SystemUser owner;

    private List<Colunas> columns;
    private List<Linhas> rows;


    public CreateSharedBoardBuilder withTile(final String title) {
        this.title = new SharedBoardTitle(title);
        return this;
    }

    public CreateSharedBoardBuilder withPosition(final SharedBoardColumnAndRow position){
        this.position = position;
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

    public CreateSharedBoardBuilder withColumns(List<Colunas> columns) {
        this.columns = columns;
        return this;
    }

    public CreateSharedBoardBuilder withRows(List<Linhas> rows) {
        this.rows = rows;
        return this;
    }

    public SharedBoard build() {
        return new SharedBoard(title, archive, owner, position, columns, rows);
    }


}
