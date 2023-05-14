package eapli.base.question.application;

import eapli.base.domain.Question;
import eapli.base.domain.QuestionBuilder;
import eapli.base.domain.QuestionType;
import eapli.base.domain.Solution;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.QuestionRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UseCaseController
@Component
public class AddUpdateExamQuestionsController {

    @Autowired
    private QuestionRepository questionRepository;


    @Transactional
    public Question createMatchingQuestion(final String question, final String[] solution, final String[] matchingOptions, final String[] matchingAnswers, final int option) {
        final List<String> options = new ArrayList<>();
        for (int i = 0; i < matchingOptions.length; i++) {
            options.add(matchingOptions[i]);
        }
        final List<String> answers = new ArrayList<>();
        for (int i = 0; i < matchingAnswers.length; i++) {
            answers.add(matchingAnswers[i]);
        }
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theListOfSolutions(Solution.valueOf(solution))
                .definedQuestion(question).definedMultiOrMatchingSolutions(solution).definedMultipleOrMatchingOptions(options)
                .definedMatchingAnswers(answers).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }


    @Transactional
    public Question createMultipleChoiceQuestion(final String question, final String solutionIndex, final String[] multipleChoice, final int option) {
        final List<String> options = new ArrayList<>();
        for (int i = 0; i < multipleChoice.length; i++) {
            options.add(multipleChoice[i]);
        }
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solutionIndex))
                .definedQuestion(question).definedSolution(solutionIndex).definedMultipleOrMatchingOptions(options)
                .ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }


    @Transactional
    public Question createShortAnswerQuestion(final String question, final String solution, final String caseSensitive, final int option) {
        boolean isCaseSensitive = false;
        if (caseSensitive.equalsIgnoreCase("yes")) {
            isCaseSensitive = true;
        }
        Solution sol=Solution.valueOf(solution);
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(sol)
                .isCaseSensitive(isCaseSensitive).definedQuestion(question).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createNumericalQuestion(final String question, final String[] solution, final String[] multipleChoice, double acceptanceError, final int option) {
        final List<String> options = new ArrayList<>();
        for (int i = 0; i < multipleChoice.length; i++) {
            options.add(multipleChoice[i]);
        }

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theListOfSolutions(Solution.valueOf(solution)).definedQuestion(question)
                .definedMultipleOrMatchingOptions(options).definedAcceptanceError(acceptanceError).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createSelectMissingWordsQuestion(final String question, final String[] solutions, final String[] words, final int option) {
        final List<String> missingWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            missingWords.add(words[i]);
        }

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theListOfSolutions(Solution.valueOf(solutions)).definedQuestion(question)
                .definedMultiOrMatchingSolutions(solutions).definedMultipleOrMatchingOptions(missingWords).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createTrueOrFalseQuestion(final String question, final String solution, final int option) {
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solution)).definedQuestion(question)
                .ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    public Map<Integer, QuestionType> getAllQuestionTypes() {
        return QuestionType.getListOfQuestionTypes();
    }

    public QuestionType getQuestionType(int option) {
        return QuestionType.getQuestionType(option);
    }


}
