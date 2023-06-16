package eCourse.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Optional;

@Embeddable
@EqualsAndHashCode
public class StudentsInCourse implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private final Student student;

    /**
     * In this case we use a String instead of a value object to show case the use of the
     * ElementCollection annotation. Since hibernate struggles with embeddables contained in other
     * embeddables when using ElementCollection.
     */
    @XmlElement
    @JsonProperty
    private final String description;

    public StudentsInCourse(final Student student, final String description) {
        this.student = student;
        this.description = description;
    }

    protected StudentsInCourse() {
        // for ORM only
        student = null;
        description = null;
    }

    public StudentsInCourse(final Student student) {
        Preconditions.nonNull(student);
        this.student = student;
        description = null;
    }

    public Student student() {
        return student;
    }

    public Optional<String> description() {
        return Optional.ofNullable(description);
    }

}
