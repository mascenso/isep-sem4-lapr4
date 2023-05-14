package eapli.base.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.Column;
import java.util.List;

public class CreateSharedBoardBuilder implements DomainFactory<SharedBoard> {


    private SharedBoardTitle title;

    private int numberColumns;

    private int numberRows;

    private boolean archive;

    private SystemUser owner;

    private List<Coluna> columns;
    private List<Linha> rows;


    public CreateSharedBoardBuilder withTile(final String title) {
        this.title = new SharedBoardTitle(title);
        return this;
    }

    public CreateSharedBoardBuilder withNumberOfColumns(final int numberOfColumns){
        this.numberColumns = numberOfColumns;
        return this;
    }

    public CreateSharedBoardBuilder withNumberOfRows(final int numberOfRows){
        this.numberRows = numberOfRows;
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

    public CreateSharedBoardBuilder withColumns(List<Coluna> columns) {
        this.columns = columns;
        return this;
    }

    public CreateSharedBoardBuilder withRows(List<Linha> rows) {
        this.rows = rows;
        return this;
    }

    public SharedBoard build() {
        return new SharedBoard(title, numberColumns, numberRows, archive, owner,  columns, rows);
    }


    public CreateSharedBoardBuilder withTitle(SharedBoardTitle title) {
       this.title = title;
       return this;
    }
}
