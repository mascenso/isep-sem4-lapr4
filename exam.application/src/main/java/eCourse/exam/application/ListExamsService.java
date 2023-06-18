package eCourse.exam.application;

import eCourse.application.CourseEnrollmentRequestService;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class ListExamsService {

    private static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<Exam> allExams(){
        return PersistenceContext.repositories().exams().findAll();
    }

    private CourseEnrollmentRequestService enrollmentRequestService = new CourseEnrollmentRequestService();

    public Iterable<GradeOfExam> allExamGrades(){
        return PersistenceContext.repositories().gradesForExam().findAll();
    }

    public List<GradeOfExam> examGradesOfLoggedStudent() {
        List<GradeOfExam> loggedStudentExams = new ArrayList<>();
        SystemUser loggedUser = authz.session().get().authenticatedUser();
        for (GradeOfExam gradeOfExam : allExamGrades()) {
            if (gradeOfExam.studentWhoDidExam().equals(loggedUser)) {
                loggedStudentExams.add(gradeOfExam);
            }
        }
        return loggedStudentExams;
    }



    public List<Exam> examOfLoggedStudent(Student student) {

        List<Exam> loggedStudentExams = new ArrayList<>();

        Iterable<Course> enrolledCourses = PersistenceContext.repositories().courses().findAll();

        for (Course course : enrolledCourses) {
            if (course.getCourseState().getActualState().equals("Progress")) {
                CourseEnrollmentRequest enrollmentRequest = enrollmentRequestService.getStudentEnrollment(student, course);

                if (enrollmentRequest != null && enrollmentRequest.courseEnrollmentStatus() == EnrollmentStatus.ACCEPTED) {
                    List<Exam> exams = getExamByCourse(course);
                    loggedStudentExams.addAll(exams);
                }
            }
        }
        return loggedStudentExams;
    }

    public List<Exam> getExamByCourse(Course course) {
        List<Exam> examListByCourse = new ArrayList<>();
        for (Exam exm : allExams()) {
            if (exm.getExamCourse().equals(course)) {
                examListByCourse.add(exm);
            }
        }
        return examListByCourse;
    }


    public Iterable<Exam> ExamsUnsolved(){
        return PersistenceContext.repositories().exams().findAll();
    }

    public List<GradeOfExam> examGradesOfLoggedTeacher() {
        List<GradeOfExam> loggedTeacherExams = new ArrayList<>();
        SystemUser loggedUser = authz.session().get().authenticatedUser();
        for (GradeOfExam gradeOfExam : allExamGrades()) {
            if (gradeOfExam.theExam().getTeacher().user().equals(loggedUser)) {
                loggedTeacherExams.add(gradeOfExam);
            }
        }
        return loggedTeacherExams;
    }

    public List<AutomaticExame> AutomaticExamsUnsolved() {
        return (List<AutomaticExame>) PersistenceContext.repositories().automaticExams().findAll();
    }
}