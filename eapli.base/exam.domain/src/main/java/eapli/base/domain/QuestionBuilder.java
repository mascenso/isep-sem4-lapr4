package eapli.base.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;

public class QuestionBuilder implements DomainFactory<Question> {

    private Description description;

    private Question theQuestion;
    private Solution theSolution;
    private String[] multipleChoice;
    private String[] matchingSolution;

    private Double acceptanceError;

    private String question;
    private Boolean caseSensitive;

    private String answer;
    private String[] matchingOptions;

    private String[] matchingAnswers;
    private String[] solutions;

    private String solution;

    private QuestionType questionType;


    public QuestionBuilder theQuestion(final Question question) {
        this.theQuestion = question;
        return this;
    }

    public QuestionBuilder theSolution(final Solution solution) {
        this.theSolution = solution;
        return this;
    }

    public QuestionBuilder descriptioned(final Description question) {
        this.description = question;
        return this;
    }

    public QuestionType theQuestionType(final int option) {

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
        return this.questionType = questionType;
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
                    theQuestion = new Question(question, matchingSolution, matchingOptions, matchingAnswers, questionType);
                    break;
                case MULTIPLE_CHOICE:
                    theQuestion = new Question(question, solution, multipleChoice, questionType);
                    break;
                case SHORT_ANSWER:
                    theQuestion = new Question(question, solution, questionType);
                    break;
                case NUMERICAL:
                    theQuestion = new Question(question, solutions, multipleChoice, acceptanceError, questionType);
                    break;
                case SELECT_MISSING_WORDS:
                    theQuestion = new Question(question, solutions, multipleChoice, questionType);
                    break;
                case TRUE_FALSE:
                    theQuestion = new Question(question, solution, answer, questionType);
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

