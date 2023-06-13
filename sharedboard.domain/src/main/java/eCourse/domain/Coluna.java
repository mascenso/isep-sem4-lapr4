package eCourse.domain;

import javax.persistence.*;

@Embeddable
public class Coluna {
    private static final long serialVersionUID = 1L;

    //private int position;

    @Column
    private String name;


    /*public Colunas(int position){
        if (position < 1){
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        this.position = position;
    }*/
    protected Coluna() {

    }

    public Coluna(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
