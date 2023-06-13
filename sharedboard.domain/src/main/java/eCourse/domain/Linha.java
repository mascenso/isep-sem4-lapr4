package eCourse.domain;

import javax.persistence.*;

@Embeddable
public class Linha {

    //private static final long serialVersionUID = 1L;

    //private int position;


    @Column
    private String name;

    //@ManyToOne SharedBoard sharedBoard;


    protected Linha() {

    }

    public Linha(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
