package eCourse.domain;

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

    protected void setName(String name) {
        this.name = name;
    }

    protected void setIndex(int index) {
        this.index = index;
    }
}
