package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GradeOfExam implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGrade;

    @ManyToOne
    private SystemUser student;

    @ManyToOne
    private Exam exam;

    private Date date;

    private float grade;

    public GradeOfExam(){}

    public GradeOfExam(SystemUser student,Float grade, Exam exam){
        this.date = new Date();
        this.student = student;
        this.grade = grade;
        this.exam = exam;

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return idGrade;
    }

    public float getGrade() {
        return grade;
    }

    public SystemUser getStudent() {
        return student;
    }


}
