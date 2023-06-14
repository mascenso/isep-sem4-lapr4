package eCourse.domain.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public class SBColumn {

    private String name;
    private int index;

    protected SBColumn() {
    }

    public SBColumn(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
