package eCourse;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class MechanographicNumber implements ValueObject, Comparable<MechanographicNumber> {

    private static final long serialVersionUID = 1L;

    private String number;

    public MechanographicNumber(final String mecanographicNumber) {
        if (StringPredicates.isNullOrEmpty(mecanographicNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.number = mecanographicNumber;
    }

    protected MechanographicNumber() {
        // for ORM
    }

    public static MechanographicNumber valueOf(final String mecanographicNumber) {
        return new MechanographicNumber(mecanographicNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MechanographicNumber)) {
            return false;
        }

        final MechanographicNumber that = (MechanographicNumber) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public int compareTo(final MechanographicNumber arg0) {
        return number.compareTo(arg0.number);
    }
}

