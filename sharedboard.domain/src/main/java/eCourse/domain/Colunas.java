package eCourse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Colunas {
    private static final long serialVersionUID = 1L;

    //private int position;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;


    /*public Colunas(int position){
        if (position < 1){
            throw new IllegalArgumentException("Column value must be between 1 and 10");
        }
        this.position = position;
    }*/
    protected Colunas() {

    }

    public Colunas(String name) {
        this.name = name;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
