package eCourse.lesson.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import eCourse.TeacherUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

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

    @ManyToOne
    private TeacherUser recurringLessonTeacher;


    //@OneToMany(mappedBy = "recurringLesson", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "recurringLesson", cascade = CascadeType.ALL)
    private List<ParticipantsOfRecurringLesson> participants;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar endDate;

    //@Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int frequency;

    protected RecurringLesson(TeacherUser recurringLessonTeacher, Designation title, Calendar startDate, Calendar endDate, LocalTime startTime, int duration, int frequency) {
        Preconditions.noneNull(title, startDate, endDate, startTime, duration, frequency);
        this.recurringLessonTeacher = recurringLessonTeacher;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        this.frequency = frequency;
    }

    protected RecurringLesson() {
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
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
        return recurringLessonTeacher.equals(that.recurringLessonTeacher) && identity().equals(that.identity()) && startDate.equals(that.startDate) && endDate.equals(that.endDate) &&
        startTime == that.startTime && duration == that.duration && frequency == that.frequency;
    }

    @Override
    public <R> R buildRepresentation(final RepresentationBuilder<R> builder) {
        return null;
    }

    public TeacherUser responsibleTeacher() { return this.recurringLessonTeacher; }

    @Override
    public Designation identity() { return this.title; }

    public Designation title() { return this.title;}

    public Calendar startDate() { return this.startDate;}

    public Calendar endDate() { return this.endDate;}

    public LocalTime startTime() { return this.startTime;}

    public int duration() { return this.duration;}

    public int frequency() { return this.frequency;}

    public RecurringLesson updateScheduleOfLesson(Calendar startDate, Calendar endDate, int duration){
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }
}
