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

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof CourseState)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        CourseState c = (CourseState) o;
        return this.actualState.equals(c.actualState);
    }

    @Override
    public int hashCode() {
        return this.actualState.hashCode();
    }
}
