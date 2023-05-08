package eapli.base;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Row implements ValueObject {
    @Id
    private Long id;

    @Column
    private int position;

    public Row(int position){
        if ( (position < 1) && (position > 20) ){
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.position = position;
    }
    public Row() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
