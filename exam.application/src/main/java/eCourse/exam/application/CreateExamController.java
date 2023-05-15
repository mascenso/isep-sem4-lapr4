package eCourse.exam.application;

import eCourse.domain.*;
import eCourse.course.application.ListCoursesService;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.repositories.ExamRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@UseCaseController
@Component
public class CreateExamController {
    @Autowired
    private ListCoursesService courseService = new ListCoursesService();

    @Autowired
    private CourseRepository repo;
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;


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
    public Exam createExam(final Course course, final String title, Date openDate, Date endDate, final Header header, final List<SequenceSection> sequenceSections) {

        ExamTitle examTitle=ExamTitle.valueOf(title);
        final Exam newExam = new ExamBuilder().theCourse(course).theExamTitle(examTitle).theOpenDate(openDate)
                .theCloseDate(endDate).theHeader(header).theSequenceSection(sequenceSections).build();

        return PersistenceContext.repositories().exams().save(newExam);
    }

    public List<Course> getOpenCourses() {
        List<Course> openCourses = new ArrayList<>();
        for (Course course : courseService.allCourses()) {
            if (course.getCourseState().getActualState().equals("Open")) {
                openCourses.add(course);
            }
        }
        return openCourses;
    }

    public Course findCourse(final Designation designation) {
        return courseRepository.findByDesignation(designation).orElseThrow(() ->
                new IllegalArgumentException("Course not found with designation: " + designation));
    }

    public Map<Integer, FeedbackType> getAllFeedbackTypes() {
        return FeedbackType.getListOfFeedbackTypes();
    }


    public Map<Integer, GradeType> getAllGradeTypes() {
        return GradeType.getListOfGradeTypes();
    }
}
