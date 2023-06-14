package eCourse.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Embeddable
public class Birthdate implements ValueObject, Comparable<Birthdate> {
    private static final long MAXIMUM_AGE = 100;

    @Column(name = "Birthdate")
    private LocalDate birthdate;

    public Birthdate(LocalDate birthdate) {
        Preconditions.nonNull(birthdate);

        if (ChronoUnit.YEARS.between(birthdate, LocalDate.now()) > MAXIMUM_AGE)
            throw new IllegalArgumentException("Invalid birthdate \"" + birthdate + "\".");

        this.birthdate = birthdate;
    }

    protected Birthdate() {}

    public static Birthdate valueOf(final LocalDate birthDate) {
        return new Birthdate(birthDate);
    }

    @Override
    public int compareTo(Birthdate otherDate) {
        return birthdate.compareTo(otherDate.birthdate);
    }

    @Override
    public String toString() {
        return birthdate.toString();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int age() {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }


}
