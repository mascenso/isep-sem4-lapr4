package eapli.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
public class CourseEdition {
    @Column(
            name = "Edition"
    )
    @XmlAttribute
    @JsonProperty("Edition")
    private final String edition;

    protected CourseEdition(final String yearEdition){this.edition = yearEdition;}

    protected CourseEdition(){this.edition="";}

    public static CourseEdition valueOf(final String yearEdition){
        Preconditions.nonEmpty(yearEdition, "Edition cannot be empty");
        return new CourseEdition(yearEdition);
    }

    @Override
    public String toString() {
        return edition ;
    }
}
