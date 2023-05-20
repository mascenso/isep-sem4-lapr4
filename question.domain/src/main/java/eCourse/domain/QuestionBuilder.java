package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.io.File;
import java.util.List;

public class QuestionBuilder implements DomainFactory<Question> {


    private Course course;

    private File file;

    private QuestionType questionType;

    private Question theQuestion;

    private String description;

    public QuestionBuilder theFile(final File file) {
        this.file = file;
        return this;
    }

    public QuestionBuilder theQuestionType(final QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }

    public QuestionBuilder theCourse(final Course course) {
        this.course = course;
        return this;
    }
    public QuestionBuilder theDescription(final String description) {
        this.description = description;
        return this;
    }

    private Question buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theQuestion != null) {
            return theQuestion;
        }
        if (course != null && questionType != null && file != null) {
            theQuestion = new Question(questionType, course, file,description);
            return theQuestion;
        }
        throw new IllegalStateException();
    }

    @Override
    public Question build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theQuestion = null;
        return ret;
    }
}

