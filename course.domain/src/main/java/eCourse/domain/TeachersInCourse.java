package eCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eCourse.Teacher;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Optional;

/**
 * A teacher in a course.
 *
 */
@Embeddable
@EqualsAndHashCode
public class TeachersInCourse implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;

    // TODO Teacher's identity class
    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private final Teacher teacher;

    /**
     * In this case we use a String instead of a value object to show case the use of the
     * ElementCollection annotation. Since hibernate struggles with embeddables contained in other
     * embeddables when using ElementCollection.
     */
    @XmlElement
    @JsonProperty
    private final String description;

    protected TeachersInCourse() {
        // for ORM only
        teacher = null;
        description = null;
    }

    public TeachersInCourse(final Teacher teacher) {
        Preconditions.nonNull(teacher);
        this.teacher = teacher;
        description = null;
    }

    public TeachersInCourse(final Teacher teacher, final String description) {
        Preconditions.noneNull(teacher, description);
        this.teacher = teacher;
        this.description = description;
    }

    public Teacher teacher() {
        return teacher;
    }

    public Optional<String> description() {
        return Optional.ofNullable(description);
    }
}