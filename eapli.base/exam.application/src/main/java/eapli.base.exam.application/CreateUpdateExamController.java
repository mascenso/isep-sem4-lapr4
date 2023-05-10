package eapli.base.exam.application;

import eapli.base.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.ExamRepository;
import eapli.base.repositories.QuestionRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
@Component
public class CreateUpdateExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public SequenceSection createSections(final Integer sectionNumber, final String decription, final List<Question> questions) {
        final SequenceSection newSQ = SequenceSection.valueOf(sectionNumber, decription, questions);
        return newSQ;
    }


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

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solution, matchingOptions, matchingAnswers, new QuestionBuilder().theQuestionType(option))).build();

        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }


    @Transactional
    public Question createMultipleChoiceQuestion(final String question, final String solutionIndex, final String[] multipleChoice, final int option) {
        final List<String> options = new ArrayList<>();
        for (int i = 0; i < multipleChoice.length; i++) {
            options.add(multipleChoice[i]);
        }

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solutionIndex, multipleChoice, new QuestionBuilder().theQuestionType(option))).build();

        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }


    @Transactional
    public Question createShortAnswerQuestion(final String question, final String solution, final int option) {

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solution, new QuestionBuilder().theQuestionType(option))).build();

        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }

    @Transactional
    public Question createNumericalQuestion(final String question, final String[] solution, final String[] multipleChoice, double acceptanceError, final int option) {
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solution, multipleChoice, acceptanceError, new QuestionBuilder().theQuestionType(option))).build();
        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }

    @Transactional
    public Question createSelectMissingWordsQuestion(final String question, final String[] solution, final String[] words, final int option) {
        final List<String> missingWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            missingWords.add(words[i]);
        }
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solution, words, new QuestionBuilder().theQuestionType(option))).build();
        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }

    @Transactional
    public Question createTrueOrFalseQuestion(final String question, final String solution, final int option) {
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question))
                .theQuestion(Question.valueOf(question, solution, new QuestionBuilder().theQuestionType(option))).build();
        return PersistenceContext.repositories().questionRepository().save(newQuestion);
    }

}
