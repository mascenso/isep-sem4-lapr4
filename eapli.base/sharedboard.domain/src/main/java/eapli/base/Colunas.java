package eapli.base;

import eapli.framework.domain.model.ValueObject;

public class Colunas implements ValueObject {
    private static final long serialVersionUID = 1L;

    private int position;

    public Colunas(int position){
        if (position < 1){
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        this.position = position;
    }
    protected Colunas() {

    }
}
