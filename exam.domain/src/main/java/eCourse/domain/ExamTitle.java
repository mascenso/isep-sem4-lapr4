package eCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;


public class ExamTitle implements Serializable,ValueObject, Comparable<ExamTitle> {
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

    public String getExamTitle() {
        return title;
    }

    protected ExamTitle(){
        // for ORM
    }


    public static ExamTitle valueOf(final String title) {
        Preconditions.nonEmpty(title, "Title cannot be empty");
        return new ExamTitle(title);
    }

    @Override
    public String toString() {
        return "ExamTitle{" +
                "title='" + title + '\'' +
                '}';
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExamTitle)) {
            return false;
        }

        final ExamTitle that = (ExamTitle) o;
        return this.title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }


    @Override
    public int compareTo(ExamTitle otherTitle) {
        return title.compareTo(otherTitle.title);
    }

}

