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
package eCourse.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;


@Embeddable
public class Acronym implements ValueObject, Comparable<Acronym> {

    private static final long serialVersionUID = 1L;

    private final String acronym;

    public Acronym(final String acronym) {
        Preconditions.nonEmpty(acronym,
                "Acronym should neither be null nor empty");

        Preconditions.ensure(acronym.length() == 3, "Acronym should have 3 letters");

        this.acronym = acronym;
    }

    protected Acronym() {
        // for ORM
        acronym = null;
    }

    public static Acronym valueOf(final String acronym) {
        return new Acronym(acronym);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Acronym)) {
            return false;
        }

        final Acronym that = (Acronym) o;
        return this.acronym.equals(that.acronym);
    }

    @Override
    public String toString() {
        return acronym;
    }

    @Override
    public int compareTo(final Acronym o) {
        return acronym.compareTo(o.acronym);
    }

    @Override
    public int hashCode() {
        return acronym.hashCode();
    }


}
