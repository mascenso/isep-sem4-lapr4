package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;


public class Header {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    protected Header(final String description, final Integer feedbackType, final Integer gradeType) {
        Preconditions.noneNull(description, feedbackType, gradeType);
        this.description = description;
        this.feedbackType = typesOfFeedback(feedbackType);
        this.gradeType = typesOfGrades(gradeType);

    }


    protected Header() {
        //for ORM only
    }

    public static Header valueOf(final String description, final Integer feedbackType, final Integer gradeType) {
        Preconditions.nonEmpty(description, "Description cannot be empty");
        Preconditions.nonEmpty(String.valueOf(feedbackType), "Feedback type cannot be empty");
        Preconditions.nonEmpty(String.valueOf(gradeType), "Grade type cannot be empty");
        return new Header(description, feedbackType, gradeType);
    }


    private GradeType typesOfGrades(final int option) {

        switch (option) {
            case 1:
                gradeType = GradeType.NONE;
                break;
            case 2:
                gradeType = GradeType.ON_SUBMISSION;
                break;
            case 3:
                gradeType = GradeType.AFTER_CLOSING;
                break;
            case 0:
                break;
        }
        return this.gradeType;
    }

    private FeedbackType typesOfFeedback(final int option) {

        switch (option) {
            case 1:
                feedbackType = FeedbackType.NONE;
                break;
            case 2:
                feedbackType = FeedbackType.ON_SUBMISSION;
                break;
            case 3:
                feedbackType = FeedbackType.AFTER_CLOSING;
                break;
            case 0:
                break;
        }
        return this.feedbackType;
    }

}
