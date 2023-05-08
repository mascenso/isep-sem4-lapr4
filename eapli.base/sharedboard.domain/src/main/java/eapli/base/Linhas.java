package eapli.base;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Linhas implements ValueObject {

    private static final long serialVersionUID = 1L;

    private int position;

    public Linhas(int position){
        if ( (position < 1) && (position > 20) ){
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.position = position;
    }
    protected Linhas() {

    }
}
