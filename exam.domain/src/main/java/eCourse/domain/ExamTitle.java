package eCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.Objects;


public class ExamTitle implements Serializable, ValueObject, Comparable<ExamTitle> {
    private static final long serialVersionUID = 1L;

    @Column(
            name = "Title"
    )
    @XmlAttribute
    @JsonProperty("Title")
    private String title;

    protected ExamTitle(final String title) {
        this.title = title;
    }

    public String getExamName() {
        return title;
    }

    protected ExamTitle() {
        // for ORM
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public static ExamTitle valueOf(final String title) {
        Preconditions.nonEmpty(title, "Title cannot be empty");
        return new ExamTitle(title);
    }


    @Override
    public String toString() {
        return title;
    }


    @Override
    public int compareTo(ExamTitle otherTitle) {
        return title.compareTo(otherTitle.title);
    }

}

