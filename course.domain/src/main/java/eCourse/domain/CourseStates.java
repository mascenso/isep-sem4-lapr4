package eCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
public final class CourseStates {/*

    private static final String OPEN = "Open";
    private static final String CLOSE = "Close";
    private static final String ENROLL = "Enroll";
    private static final String PROGRESS = "Progress";


    @Column(
            name = "State"
    )
    @XmlAttribute
    @JsonProperty("State")
    private final String actualState;

    protected CourseStates() {
        this.actualState = "no state";
    }

    public static String[] stateValues (){
        return new String[]{OPEN,CLOSE,ENROLL,PROGRESS};
    }

    protected CourseStates(final String state){
        this.actualState = state;}

    public String getActualState() {
        return this.actualState;
    }

    public static CourseStates valueOf(final String state){
        Preconditions.nonEmpty(state, "Edition cannot be empty");
        return new CourseStates(state);
    }

    @Override
    public String toString() {
        return actualState;
    }*/
}
