package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.File;

@Entity
public class Question implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private File file;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Course course;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;


    protected Question(final QuestionType questionType, final Course course, final File file, final String description) {
        Preconditions.noneNull(questionType, course, file, description);
        this.questionType = questionType;
        this.course = course;
        this.file = file;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    protected Question() {
        //for ORM only
    }

    public static Question valueOf(final QuestionType questionType, final Course course, final File file, final String description) {
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        Preconditions.noneNull(course, "Course cannot be empty");
        Preconditions.noneNull(file, "File cannot be empty");
        Preconditions.noneNull(description, "Description cannot be empty");
        return new Question(questionType, course, file,description);
    }


    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Question)) {
            return false;
        }

        final Question otherQuestion = (Question) other;

        return questionType.equals(otherQuestion.questionType)
                && course.equals(otherQuestion.course)
                && file.equals(otherQuestion.file);
    }

    public Course getQuestionCourse() {
        return course;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
    public String getQuestionDescription() {
        return description;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public Long identity() {
        return id;
    }

    public Question updateQuestion(File file, QuestionType questionType, Course course) {
        this.file=file;
        this.questionType=questionType;
        this.course=course;
        return this;
    }


    public File getFile() {
        return file;
    }
}
