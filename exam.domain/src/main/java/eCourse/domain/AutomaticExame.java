package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.io.File;
import java.util.*;

@Entity
public class AutomaticExame implements AggregateRoot<ExamTitle> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "exam")
    private Set<GradeOfExam> examGrades;

    @ManyToOne
    private Teacher teacher;

    public AutomaticExame(ExamTitle examTitle, Course theCourse, Teacher theTeacher, File file) {
        Preconditions.noneNull(examTitle, theCourse, file);
        this.title =examTitle;
        this.course = theCourse;
        this.teacher = theTeacher;
        this.file=file;

    }

    public Set<GradeOfExam> getExamGrades() {
        return examGrades;
    }

    @Column(unique = true)
    private ExamTitle title;


    @Column(nullable = false)
    private File file;

    protected AutomaticExame() {
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

    public File getExamFile() {
        return file;
    }

    public Teacher getTeacher() { return teacher; }

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
                && file.equals(otherExam.file);
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
