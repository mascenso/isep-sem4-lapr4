package eCourse.course.application;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseEnrollmentRequestRepository;
import eCourse.repositories.CourseRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.util.Calendar;

public class CourseEnrollmentRequestController {

    //private CourseRepository courseRepository;

    //private UserRepository userRepository;

    public String getCourseStates(CourseState courseState){
        return courseState.getActualState();
    }

    private final CourseEnrollmentRequestRepository courseEnrollmentRequestRepository = PersistenceContext.repositories().courseEnrollmentRequests();

    public CourseEnrollmentRequest courseEnrollment(final Username username, final Designation name,
                                                    final EmailAddress email, final ApprovalStatus approvalStatus, final Calendar createdOn,
                                                    final Designation courseName, final CourseEdition courseEdition, final CourseState courseState) {

        final CourseEnrollmentRequestBuilder courseEnrollmentRequestBuilder = new CourseEnrollmentRequestBuilder();

        courseEnrollmentRequestBuilder.named(name).withData(username, email).approved(approvalStatus).created(createdOn).courseNamed(courseName).edition(courseEdition).state(courseState);

        //courseRepository.ofIdentity(courseName).get().

        final CourseEnrollmentRequest newCourseEnrollmentRequest = courseEnrollmentRequestBuilder.build();
        return this.courseEnrollmentRequestRepository.save(newCourseEnrollmentRequest);
    }




}
