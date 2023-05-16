package eCourse.lesson.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Duration;
import java.util.Calendar;

@XmlRootElement
@Entity
public class RecurringLesson implements AggregateRoot<Designation>, Representationable {
    /**
     * The primary key of lesson is the unique title
     */
    @XmlElement
    @JsonProperty
    @EmbeddedId
    private Designation title;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar endDate;

    @Column(nullable = false)
    private Duration duration;

    protected RecurringLesson(Designation title, Calendar startDate, Calendar endDate, Duration duration) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
    }

    protected RecurringLesson() {
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof RecurringLesson)) {
            return false;
        }

        final RecurringLesson that = (RecurringLesson) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && duration.equals(that.duration);
    }

    @Override
    public <R> R buildRepresentation(final RepresentationBuilder<R> builder) {
        return null;
    }

    @Override
    public Designation identity() { return this.title; }

    public Designation title() { return this.title;}

    public Calendar startDate() { return this.startDate;}

    public Calendar endDate() { return this.endDate;}

    public Duration duration() { return this.duration;}

    public RecurringLesson updateScheduleOfLesson(Calendar startDate, Calendar endDate, Duration duration){
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }
}
