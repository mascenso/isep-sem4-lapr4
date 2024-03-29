package eCourse.domain;

import javax.persistence.*;

@Embeddable
public class SBRow {

    private String name;
    private int index;

    protected SBRow() {
    }

    public SBRow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setIndex(int index) {
        this.index = index;
    }
}
