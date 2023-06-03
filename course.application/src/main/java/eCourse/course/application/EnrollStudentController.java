package eCourse.course.application;

import eCourse.MechanographicNumber;
import eCourse.domain.Course;
import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.repositories.StudentRepository;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class EnrollStudentController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final StudentRepository studentRepository = PersistenceContext.repositories().students();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courses();

    private ListCoursesService service = new ListCoursesService();


    private static final String CSV_DELIMITER = ",";
    private static final int CSV_STUDENT_IDENTITY_INDEX = 0;


    public BulkCsvValidateResult BulkCsvValidate(String csvContent) {

        //1 - validate if the user is authenticated and has a valid role
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER, ECourseRoles.POWER_USER, ECourseRoles.ADMIN);

        //2 - validate params
        Preconditions.nonEmpty(csvContent); //the csvContent cannot be empty

        Stream<String> lines = csvContent.lines();

        //the validation results of the CSV will be stored in validationResult
        BulkCsvValidateResult validationResult = new BulkCsvValidateResult();

        lines.forEach((studentRow) -> {

            String[] values = studentRow.split(CSV_DELIMITER);

            if (values.length > CSV_STUDENT_IDENTITY_INDEX) {

                Optional<Student> studentEntity = studentRepository.findByMechanographicNumber(MechanographicNumber.valueOf(values[CSV_STUDENT_IDENTITY_INDEX]));

                if (studentEntity.isPresent()) {
                    validationResult.addValidStudent(studentEntity.get()); //the student exists in the database
                } else {
                    validationResult.addInvalidStudentRow(studentRow); //the student does not exist in the database
                }
            } else {
                validationResult.addInvalidStudentRow(studentRow); //empty rows will be stored here
            }
        });

        return validationResult;
    }


    public void enrollStudent(String courseIdentity, List<Student> students) {

        //1 - validate if the user is authenticated and has a valid role
        this.authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER, ECourseRoles.POWER_USER, ECourseRoles.ADMIN);

        //2 - validate params
        Preconditions.nonEmpty(courseIdentity);
        Preconditions.nonEmpty(students);

        //the course to enroll must exist, otherwise an exception will be thrown
        Course course = courseRepository.findByDesignation(Designation.valueOf(courseIdentity))
                .orElseThrow(() -> new NoSuchElementException("The course " + courseIdentity + " does not exist in the database"));

        course.addAllStudent(students);

        for (Student student : students) {
            student.addCourse(course);
        }

        courseRepository.save(course);
    }

    public Iterable<Course> allCourses() {

        return service.allCourses();
    }
}
