package eCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
public final class CourseState {

    @Column(
            name = "State"
    )
    @XmlAttribute
    @JsonProperty("State")
    private final String actualState;

    protected CourseState() {
        this.actualState = "no state";
    }

    protected CourseState(final String state){this.actualState = state;}

    public static CourseState valueOf(final String state){
        Preconditions.nonEmpty(state, "Edition cannot be empty");
        return new CourseState(state);
    }

    public String getActualState() {
        return this.actualState;
    }

    @Override
    public String toString() {
        return actualState;
    }
}
