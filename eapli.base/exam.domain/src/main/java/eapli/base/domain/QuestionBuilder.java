package eapli.base.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

import java.util.List;

public class QuestionBuilder implements DomainFactory<Question> {

    private Description description;

    private Question theQuestion;
    private Solution theSolution;
    private List<String> multipleOrMatchingOptions;
    private String[] multiOrMatchingSolutions;

    private Double acceptanceError;

    private String question;
    private Boolean caseSensitive;



    private List<String>  matchingAnswers;

    private String solution;

    private QuestionType questionType;



    public QuestionBuilder definedMultipleOrMatchingOptions(final List<String> multipleOrMatchingOptions) {
        this.multipleOrMatchingOptions = multipleOrMatchingOptions;
        return this;
    }

    public QuestionBuilder definedMultiOrMatchingSolutions(final String[] MultiOrMatchingSolutions) {
        this.multiOrMatchingSolutions = MultiOrMatchingSolutions;
        return this;
    }

    public QuestionBuilder definedMatchingAnswers(final List<String>  matchingAnswers) {
        this.matchingAnswers = matchingAnswers;
        return this;
    }
    public QuestionBuilder definedAcceptanceError(final Double acceptanceError) {
        this.acceptanceError = acceptanceError;
        return this;
    }

    public QuestionBuilder definedQuestion(final String question) {
        this.question = question;
        return this;
    }

    public QuestionBuilder definedSolution(final String solution) {
        this.solution = solution;
        return this;
    }

    public QuestionBuilder isCaseSensitive(final Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }


    public QuestionBuilder theSolution(final Solution solution) {
        this.theSolution = solution;
        return this;
    }
    public QuestionBuilder ofType(final QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }


    public QuestionBuilder descriptioned(final Description question) {
        this.description = question;
        return this;
    }

    public QuestionType getQuestionType(final int option){
        return questionTypeAssignement(option);
    }

    private QuestionType questionTypeAssignement(final int option) {

        switch (option) {
            case 1:
                questionType = QuestionType.MATCHING;
                break;
            case 2:
                questionType = QuestionType.MULTIPLE_CHOICE;
                break;
            case 3:
                questionType = QuestionType.SHORT_ANSWER;
                break;
            case 4:
                questionType = QuestionType.NUMERICAL;
                break;
            case 5:
                questionType = QuestionType.SELECT_MISSING_WORDS;
                break;
            case 6:
                questionType = QuestionType.TRUE_FALSE;
                break;
            case 0:
                break;
        }
        return this.questionType;
    }

    private Question buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theQuestion != null) {
            return theQuestion;
        }
        if (question != null && solution != null) {
            switch (questionType) {
                case MATCHING:
                    theSolution=new Solution(multiOrMatchingSolutions);
                    theQuestion = new Question(question, theSolution, multipleOrMatchingOptions, matchingAnswers, questionType);
                    break;
                case MULTIPLE_CHOICE:
                    theSolution=new Solution(solution);
                    theQuestion = new Question(question, theSolution, multipleOrMatchingOptions, questionType);
                    break;
                case SHORT_ANSWER:
                    theSolution=new Solution(solution);
                    theQuestion = new Question(question, theSolution, caseSensitive, questionType);
                    break;
                case NUMERICAL:
                    theSolution=new Solution(multiOrMatchingSolutions);
                    theQuestion = new Question(question, theSolution, multipleOrMatchingOptions, acceptanceError, questionType);
                    break;
                case SELECT_MISSING_WORDS:
                    theSolution=new Solution(multiOrMatchingSolutions);
                    theQuestion = new Question(question, theSolution, multipleOrMatchingOptions, questionType);
                    break;
                case TRUE_FALSE:
                    theSolution=new Solution(solution);
                    theQuestion = new Question(question, theSolution, questionType);
                    break;
            }
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

