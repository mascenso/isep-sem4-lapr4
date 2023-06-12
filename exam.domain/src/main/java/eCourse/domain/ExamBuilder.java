package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;

import java.io.File;
import java.util.Date;

public class ExamBuilder implements DomainFactory<Exam> {
    private Exam theExam;
    private Course theCourse;
    private Teacher theTeacher;
    private ExamTitle examTitle;
    private Date openDate;
    private Date closeDate;
    private File file;

    public ExamBuilder theCourse(final Course course) {
        this.theCourse = course;
        return this;
    }

    public ExamBuilder theTeacher(final Teacher teacher) {
        this.theTeacher = teacher;
        return this;
    }

    public ExamBuilder theExamTitle(final ExamTitle title) {
        this.examTitle = title;
        return this;
    }

    public ExamBuilder theOpenDate(final Date openDate) {
        this.openDate = openDate;
        return this;
    }

    public ExamBuilder theCloseDate(final Date closeDate) {
        this.closeDate = closeDate;
        return this;
    }

    public ExamBuilder theFile(final File file) {
        this.file = file;
        return this;
    }

    private Exam buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theExam != null) {
            return theExam;
        }

        if (examTitle != null && theCourse != null && theTeacher != null && openDate != null && closeDate != null && file != null) {
            theExam = new Exam(examTitle, theCourse, theTeacher, openDate, closeDate, file);
            return theExam;
        }
        throw new IllegalStateException();
    }

    @Override
    public Exam build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theExam = null;
        return ret;
    }
}
