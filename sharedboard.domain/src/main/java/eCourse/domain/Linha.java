package eCourse.domain;

import javax.persistence.*;

@Entity
public class Linha {

    //private static final long serialVersionUID = 1L;

    //private int position;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    //@ManyToOne SharedBoard sharedBoard;


    protected Linha() {

    }

    public Linha(String name) {
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
