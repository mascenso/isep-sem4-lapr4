package eapli.base.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;

import java.util.Date;
import java.util.List;

public class ExamBuilder implements DomainFactory<Exam> {
    private Exam theExam;
    private Course theCourse;

    private ExamTitle title;

    private Designation theDescription;

    private Header theHeader;

    private Date openDate;
    private Date closeDate;

    private String examTitle;

    private List<SequenceSection> theSequenceSection;

    public ExamBuilder theCourse(final Course course) {
        this.theCourse = course;
        return this;
    }

    public ExamBuilder theExamTitle(final ExamTitle title) {
        this.title = title;
        return this;
    }

    public ExamBuilder theDescription(final Designation description) {
        this.theDescription = description;
        return this;
    }

    public ExamBuilder theHeader(final Header header) {
        this.theHeader = header;
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

    public ExamBuilder theSequenceSection(final List<SequenceSection> seqSection) {
        this.theSequenceSection = seqSection;
        return this;
    }

    private Exam buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theExam != null) {
            return theExam;
        }

        if (theCourse != null && openDate != null && closeDate != null && examTitle != null && theDescription != null && theHeader != null && theSequenceSection != null) {
            ExamTitle title = new ExamTitle(examTitle);
            theExam = new Exam(theCourse, title, openDate, closeDate, theDescription, theHeader, theSequenceSection);
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
