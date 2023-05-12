package eapli.base.exam.application;

import eapli.base.course.application.ListCoursesService;
import eapli.base.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CourseRepository;
import eapli.base.repositories.ExamRepository;
import eapli.base.repositories.QuestionRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@UseCaseController
@Component
public class CreateUpdateExamController {
    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    @Autowired
    private CourseRepository repo;
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public SequenceSection createSections(final Integer sectionNumber, final String decription, final List<Question> questions) {
        final SequenceSection newSQ = SequenceSection.valueOf(sectionNumber, decription, questions);
        return newSQ;
    }

    @Transactional
    public Header createHeader(final String decription, final Integer feedbackType, final Integer gradeType) {
        final Header newHeader = Header.valueOf(decription, feedbackType, gradeType);
        return newHeader;
    }

    @Transactional
    public Exam createExam(final Course course, final String title, Date openDate, Date endDate, final Designation designation, final Header header, final List<SequenceSection> sequenceSections) {

        final Exam newExam = new ExamBuilder().theCourse(course).theExamTitle(ExamTitle.valueOf(title)).theOpenDate(openDate)
                .theCloseDate(endDate).theDescription(designation).theHeader(header).theSequenceSection(sequenceSections).build();

        return newExam;
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
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solution))
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
    public Question createShortAnswerQuestion(final String question, final String solution, final boolean isCaseSensitive, final int option) {

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solution))
                .isCaseSensitive(isCaseSensitive).definedQuestion(question).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createNumericalQuestion(final String question, final String[] solution, final String[] multipleChoice, double acceptanceError, final int option) {
        final List<String> options = new ArrayList<>();
        for (int i = 0; i < multipleChoice.length; i++) {
            options.add(multipleChoice[i]);
        }

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solution)).definedQuestion(question)
                .definedMultipleOrMatchingOptions(options).definedAcceptanceError(acceptanceError).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createSelectMissingWordsQuestion(final String question, final String[] solutions, final String[] words, final int option) {
        final List<String> missingWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            missingWords.add(words[i]);
        }

        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solutions)).definedQuestion(question)
                .definedMultiOrMatchingSolutions(solutions).definedMultipleOrMatchingOptions(missingWords).ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    @Transactional
    public Question createTrueOrFalseQuestion(final String question, final String solution, final int option) {
        final Question newQuestion = new QuestionBuilder().descriptioned(Description.valueOf(question)).theSolution(Solution.valueOf(solution)).definedQuestion(question)
                .ofType(new QuestionBuilder().getQuestionType(option)).build();

        return PersistenceContext.repositories().questions().save(newQuestion);
    }

    public List<Course> getOpenCourses() {
        List<Course> openCourses = new ArrayList<>();
        for (Course course : courseService.allCourses()) {
            if (course.getCourseState().equals("Open")) {
                openCourses.add(course);
            }
        }
        return openCourses;
    }

    public Course findCourse(final Designation designation) {
        return courseRepository.findByDesignation(designation).orElseThrow(() ->
                new IllegalArgumentException("Course not found with designation: " + designation));
    }

}
