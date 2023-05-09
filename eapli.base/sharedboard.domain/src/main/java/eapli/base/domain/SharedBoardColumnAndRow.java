package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;

public class SharedBoardColumnAndRow implements ValueObject {

    private int numberRows;
    private int numberColumns;

    public SharedBoardColumnAndRow(int numberRows, int numberColumns) {
        if ( (numberColumns < 1) || (numberColumns > 10) ) {
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        if ( (numberRows < 1) || (numberRows > 20) ){
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.numberRows = numberRows;
        this.numberColumns = numberColumns;
    }

    protected SharedBoardColumnAndRow() {

    }

    public int getNumberRows() {
        return numberRows;
    }

    public void setNumberRows(int numberRows) {
        this.numberRows = numberRows;
    }

    public int getNumberColumns() {
        return numberColumns;
    }

    public void setNumberColumns(int numberColumns) {
        this.numberColumns = numberColumns;
    }
}
