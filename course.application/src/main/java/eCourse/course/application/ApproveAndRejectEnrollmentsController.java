package eCourse.course.application;

import eCourse.application.CourseEnrollmentRequestService;
import eCourse.domain.Course;
import eCourse.domain.CourseEnrollmentRequest;
import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ApproveAndRejectEnrollmentsController {

    private ListStudentsService studentsService = new ListStudentsService();

    private CourseEnrollmentRequestService enrollService = new CourseEnrollmentRequestService();

    private ListCoursesService service = new ListCoursesService();


    public List<Student> allStudents() {
        List<Student> studentList = new ArrayList<>();
        Iterable<SystemUser> all = studentsService.allUsers();
        for (SystemUser user : all) {
            Optional<Student> student = studentsService.findAllStudents(user);
            if (student.isPresent()) {
                studentList.add(student.get());
            }
        }
        return studentList;
    }

    public boolean allRequests(Course course, Student student) {
        Iterable<CourseEnrollmentRequest> courseRequests = enrollService.pendingCourseEnrollmentRequests();
        for (CourseEnrollmentRequest request : courseRequests) {
            if (request.courseEnrollmentRequestCourse().equals(course) && request.courseEnrollmentRequestStudent().equals(student)) {
                return true;
            }
        }
        return false;
    }

    public List<Student> studentsCourseEnrollment(Course course) {
        List<Student> allStudents = allStudents();
        List<Student> studentEnrollmentList = new ArrayList<>();

        for (Student st : allStudents) {
            if (allRequests(course, st)) {
                studentEnrollmentList.add(st);
            }
        }
        return studentEnrollmentList;
    }

    @Transactional
    public void approveStudentsEnrollment(Set<Student> approvals, Course course) {
        for (Student user : approvals) {
            CourseEnrollmentRequest requestUpdate = enrollService.getStudentEnrollment(user, course);
            requestUpdate.approveEnrollment(user);
            PersistenceContext.repositories().courseEnrollmentRequests().save(requestUpdate);
        }
    }

    @Transactional
    public void rejectStudentsEnrollment(Set<Student> rejections, Course course) {
        for (Student user : rejections) {
            CourseEnrollmentRequest requestUpdate = enrollService.getStudentEnrollment(user, course);
            requestUpdate.rejectEnrollment(user);
            PersistenceContext.repositories().courseEnrollmentRequests().save(requestUpdate);
        }
    }

    public List<Course> getEnrollmentCourses() {
        return service.getEnrollmentCourses();
    }
}
