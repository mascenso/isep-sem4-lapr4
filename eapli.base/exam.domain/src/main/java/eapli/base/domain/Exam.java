package eapli.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import org.springframework.security.web.header.Header;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exam implements AggregateRoot<Designation> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Course course;

    @XmlElement
    @JsonProperty
    @EmbeddedId
    private Designation designation;
    @Column(unique = true)
    private String title;

    @Embedded
    private Header header;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Embedded
    private List<SequenceSection> sequenceSections = new ArrayList<>();

    protected Exam(final  Course course, final Designation designation, final String title, final Header header, final List<SequenceSection> sequenceSections, LocalDate startDate, LocalDate endDate){
        Preconditions.noneNull(title,header,sequenceSections,startDate,endDate);
        this.course=course;
        this.designation=designation;
        this.title = title;
        this.header= header;
        this.sequenceSections = sequenceSections;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected Exam(){
        //for ORM only
    }


    public Designation designation(){
        return designation;
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
                && startDate.equals(otherExam.startDate)
                && endDate.equals(otherExam.endDate);
    }

    @Override
    public Designation identity() {
        return designation;
    }
}
