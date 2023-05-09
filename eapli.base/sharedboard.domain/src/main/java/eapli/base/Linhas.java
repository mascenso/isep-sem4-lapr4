package eapli.base;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Linhas {

    //private static final long serialVersionUID = 1L;

    //private int position;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne SharedBoard sharedBoard;

    /*public Linhas(int position){
        if ( (position < 1) && (position > 20) ){
            throw new IllegalArgumentException("Row value must be between 1 and 20");
        }
        this.position = position;
    }*/
    protected Linhas() {

    }

    public Linhas(String name) {
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
