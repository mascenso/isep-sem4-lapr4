package eapli.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
public class ExamTitle {

    @Column(
            name = "Title"
    )
    @XmlAttribute
    @JsonProperty("Title")
    private final String title;


    protected ExamTitle() {
        this.title = "";
    }

    protected ExamTitle(final String title) {
        this.title = title;
    }


    public static ExamTitle valueOf(final String title) {
        Preconditions.nonEmpty(title, "Title cannot be empty");
        return new ExamTitle(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
