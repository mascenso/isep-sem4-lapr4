package eapli.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

@Entity
public class Exam implements AggregateRoot<Designation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;
    @XmlElement
    @JsonProperty
    @EmbeddedId
    private Designation designation;
    @Column(unique = true)
    private ExamTitle title;

    @Embedded
    private Header header;

    @Column(nullable = false)
    private Date openDate;

    @Column(nullable = false)
    private Date closeDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SequenceSection> sequenceSections;

    protected Exam(final Course course, final ExamTitle title, Date openDate, Date endDate, final Designation designation, final Header header, final List<SequenceSection> sequenceSections) {
        Preconditions.noneNull(title, course, header, sequenceSections, openDate, endDate, designation);
        this.course = course;
        this.designation = designation;
        this.openDate=openDate;
        this.closeDate=endDate;
        this.title = title;
        this.header = header;
        this.sequenceSections = sequenceSections;
    }

    protected Exam() {
        //for ORM only
    }


    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Exam)) {
            return false;
        }

        final Exam otherExam = (Exam) other;

        return designation.equals(otherExam.designation)
                && course.equals(otherExam.course)
                && title.equals(otherExam.title)
                && header.equals(otherExam.header)
                && sequenceSections.equals(otherExam.sequenceSections)
                && openDate.equals(otherExam.openDate)
                && closeDate.equals(otherExam.closeDate);
    }

    @Override
    public Designation identity() {
        return designation;
    }
}
