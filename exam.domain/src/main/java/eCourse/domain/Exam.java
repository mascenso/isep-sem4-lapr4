package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.io.File;
import java.util.*;

@Entity
public class Exam implements AggregateRoot<ExamTitle> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Course course;

    @Column(unique = true)
    private ExamTitle title;


    @Column(nullable = false)
    private File file;

    @Column(nullable = false)
    private Date openDate;

    @Column(nullable = false)
    private Date closeDate;

    protected Exam(final ExamTitle examTitle ,final Course course, final Date openDate, final Date endDate,  final File examFile ) {
        Preconditions.noneNull(examTitle, course, openDate, endDate, examFile);
        this.title =examTitle;
        this.course = course;
        this.openDate=openDate;
        this.closeDate=endDate;
        this.file=examFile;
    }

    protected Exam() {
        //for ORM only
    }

    public Long getExamId() {
        return id;
    }

    public Course getExamCourse() {
        return course;
    }


    public ExamTitle getExamTitle() {
        return title;
    }

    public Date getExamOpenDate() {
        return openDate;
    }

    public Date getExamCloseDate() {
        return closeDate;
    }

    public File getExamFile() {
        return file;
    }

    @OneToOne(mappedBy = "exam")
    private GradeOfExam examGrade;

    public GradeOfExam getExamGrade() {
        return examGrade;
    }

    public Exam updateExam(Date open, Date close, File file){
        this.closeDate=close;
        this.openDate=open;
        this.file=file;
        return this;
    }

    @Override
    public String toString() {
        return  ""+title;
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
                && file.equals(otherExam.file)
                && openDate.equals(otherExam.openDate)
                && closeDate.equals(otherExam.closeDate);
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public ExamTitle identity() {
        return title;
    }
}
