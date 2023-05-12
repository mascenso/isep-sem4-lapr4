package eapli.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Question implements AggregateRoot<Designation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;
    @Embedded
    private Solution solution;

    @ElementCollection
    private List<String>  multiOptions;

    @ElementCollection
    private List<String>  matchingAnswers;

    @Column(nullable = false)
    private Boolean caseSensitive;

    @Column(nullable = false)
    private String answer;
    @Column(nullable = false)
    private Double acceptanceError;

    @XmlElement
    @JsonProperty
    @EmbeddedId
    private Designation designation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;


    //MATCHING
    protected Question(final String question, final Solution solution, final List<String>  matchingOptions, final List<String>  matchingAnswers, final QuestionType questionType) {
        Preconditions.noneNull(question, solution, matchingOptions, matchingAnswers, questionType);
        this.question = question;
        this.solution = solution;
        this.multiOptions = matchingOptions;
        this.matchingAnswers = matchingAnswers;
        this.questionType = questionType;
    }

    //MULTIPLE_CHOICE && SELECT_MISSING_WORDS
    protected Question(final String question, final Solution solution, final List<String>  multiOptions, final QuestionType questionType) {
        Preconditions.noneNull(question, solution, multiOptions, questionType);
        this.question = question;
        this.solution = solution;
        this.multiOptions = multiOptions;
        this.questionType = questionType;
    }

    //SHORT_ANSWER
    protected Question(final String question, final Solution solution, final boolean caseSensitive, final QuestionType questionType) {
        Preconditions.noneNull(question, solution, questionType);
        this.question = question;
        this.solution = solution;
        this.caseSensitive = caseSensitive;
        this.questionType = questionType;
    }

    //NUMERICAL
    protected Question(final String question, final Solution solution, final List<String> multiOptions,
                       final double acceptanceError, final QuestionType questionType) {
        Preconditions.noneNull(question, solution, multiOptions, acceptanceError, questionType);
        this.question = question;
        this.solution = solution;
        this.acceptanceError = acceptanceError;
        this.multiOptions = multiOptions;
        this.questionType = questionType;
    }

    /*
        //SELECT_MISSING_WORDS
        protected Question(final String question, final Solution solution, final String[] answer, final QuestionType questionType) {
            Preconditions.noneNull(question, solution, questionType);
            this.question = question;
            this.solution = solution;
            this.multiOptions = answer;
            this.questionType = questionType;
        }

       */
    //TRUE_FALSE
    protected Question(final String question, final Solution solution, final QuestionType questionType) {
        Preconditions.noneNull(question, solution, questionType);
        this.question = question;
        this.solution = solution;
        this.questionType = questionType;
    }


    protected Question() {
        //for ORM only
    }

    //MATCHING
    public static Question valueOf(final String question, final Solution solution, final List<String> matchingOptions, final List<String>  matchingAnswers, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.noneNull(solution, "Solutions cannot be empty");
        Preconditions.noneNull(matchingOptions, "Matching Options cannot be empty");
        Preconditions.noneNull(matchingAnswers, "Matching Answers cannot be empty");
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        return new Question(question, solution, matchingOptions, matchingAnswers, questionType);
    }

    //MULTIPLE_CHOICE
    public static Question valueOf(final String question, final Solution solution, final List<String>  multiOptions, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.noneNull(solution, "Solution cannot be empty");
        Preconditions.noneNull(multiOptions, "Multiple Options cannot be empty");
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        return new Question(question, solution, multiOptions, questionType);
    }

    //SHORT_ANSWER
    public static Question valueOf(final String question, final Solution solution, final boolean caseSensitive, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.noneNull(solution, "Solution cannot be empty");
        Preconditions.noneNull(caseSensitive, "Must define if is case sensitive");
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        return new Question(question, solution, caseSensitive, questionType);
    }

    //NUMERICAL
    public static Question valueOf(final String question, final Solution solution, final List<String>  multiOptions,
                                   final double acceptanceError, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.noneNull(solution, "Solution cannot be empty");
        Preconditions.noneNull(multiOptions, "Multiple Options cannot be empty");
        Preconditions.noneNull(acceptanceError, "Acceptance Error must be defined");
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        return new Question(question, solution, multiOptions, acceptanceError, questionType);
    }

    /*
    //SELECT_MISSING_WORDS
    public static Question valueOf(final String question, final Solution solution, final String[] answer, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.nonEmpty(List.of(solution), "Solutions cannot be empty");
        Preconditions.nonEmpty(List.of(answer), "Answers cannot be empty");
        Preconditions.nonEmpty(Collections.singleton(questionType), "Question type cannot be empty");
        return new Question(question,solution,answer,questionType);
    }

 */
    //TRUE_FALSE:
    public static Question valueOf(final String question, final Solution solution, final QuestionType questionType) {
        Preconditions.nonEmpty(question, "Question cannot be empty");
        Preconditions.noneNull(solution, "Solution cannot be empty");
        Preconditions.noneNull(questionType, "Question type cannot be empty");
        return new Question(question, solution, questionType);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Designation identity() {
        return null;
    }
}
