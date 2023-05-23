/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eCourse.studentusermanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Optional;

/**
 * An allergen contained in a dish. For instance, most breakfast cereals contain nuts.
 *
 * @author mcn
 */
@Embeddable
@EqualsAndHashCode
public class StudentInCourse implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;


    // TODO a Value Object should not reference an Entity due to its immutable nature. Here it would
    // be advisable to use the Student's identity class
    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private final StudentUser studentUser;

    /**
     * In this case we use a String instead of a value object to show case the use of the
     * ElementCollection annotation. Since hibernate struggles with embeddables contained in other
     * embeddables when using ElementCollection.
     */
    @XmlElement
    @JsonProperty
    private final Designation courseDesignation;

    public StudentInCourse() {
        // for ORM only
        studentUser = null;
        courseDesignation = null;
    }


    public StudentInCourse(final StudentUser studentUser, final Designation courseDesignation) {
        Preconditions.noneNull(studentUser, courseDesignation);
        this.studentUser = studentUser;
        this.courseDesignation = courseDesignation;
    }

    public StudentUser studentUser() {
        return studentUser;
    }

    public Optional<Designation> designation() {
        return Optional.ofNullable(courseDesignation);
    }

}
