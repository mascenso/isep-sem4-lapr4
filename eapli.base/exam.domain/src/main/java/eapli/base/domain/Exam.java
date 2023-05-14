package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Exam implements AggregateRoot<ExamTitle> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    @Column(unique = true)
    private ExamTitle title;

    @Embedded
    @Column(nullable = false)
    private Header header;

    public Long getExamId() {
        return id;
    }

    public ExamTitle getExamTitle() {
        return title;
    }

    @Column(nullable = false)
    private Date openDate;

    @Column(nullable = false)
    private Date closeDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SequenceSection> sequenceSections = new ArrayList<>();

    protected Exam(final Course course, final ExamTitle title, Date openDate, Date endDate,  final Header header, final List<SequenceSection> sequenceSections) {
        Preconditions.noneNull(title, course, header, sequenceSections, openDate, endDate);
        this.course = course;

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

        return course.equals(otherExam.course)
                && title.equals(otherExam.title)
                && header.equals(otherExam.header)
                && sequenceSections.equals(otherExam.sequenceSections)
                && openDate.equals(otherExam.openDate)
                && closeDate.equals(otherExam.closeDate);
    }

    @Override
    public ExamTitle identity() {
        return title;
    }
}
