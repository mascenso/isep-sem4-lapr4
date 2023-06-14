package eCourse.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseEnrollmentRequestTest {
    private CourseEnrollmentRequest courseEnrollmentRequest1;
    private CourseEnrollmentRequest courseEnrollmentRequest2;
    private CourseEnrollmentRequest courseEnrollmentRequest3;
    private Course course1;
    private Course course2;
    private Role STUDENT;
    private Set<Role> roles1 = new HashSet<>();
    private Set<Role> roles2 = new HashSet<>();
    private SystemUser student;
    private Student student1;
    private Student student2;
    private Role TEACHER;
    private SystemUser teacher;

    @BeforeEach
    public void setUp() throws ParseException {
        STUDENT = Role.valueOf("STUDENT");
        TEACHER = Role.valueOf("TEACHER");
        roles1.add(STUDENT);
        roles2.add(TEACHER);
        SystemUser student = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder()).with("Mig", "teste", "Miguel", "Seixas", "miguel@isep.pt").withRoles(roles1).build();
        SystemUser teacher = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder()).with("Mar", "teste", "Mariana", "Seixas", "mariana@isep.pt").withRoles(roles2).build();
        student1 = new StudentBuilder().build(student, "1100358");
        student2 = new StudentBuilder().build(student, "1100529");
        course1 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("ESOFT")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();
        course2 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("EAPLI")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();

        courseEnrollmentRequest1 = new CourseEnrollmentRequestBuilder().theCourse(course1).theStudent(student1).build();
        courseEnrollmentRequest2 = new CourseEnrollmentRequestBuilder().theCourse(course2).theStudent(student2).build();
        courseEnrollmentRequest3 = new CourseEnrollmentRequestBuilder().theCourse(course1).theStudent(student1).build();

    }

    @Test
    public void testIfCourseEnrollmentRequestCourseIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Course nullCourse = null;
            new CourseEnrollmentRequestBuilder().theCourse(nullCourse).theStudent(student1).build();
        });
    }

    @Test
    public void testIfCourseEnrollmentRequestStudentIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Student nullStudent = null;
            new CourseEnrollmentRequestBuilder().theCourse(course1).theStudent(nullStudent).build();
        });
    }

    @Test
    public void testIfAllParametersAreFilled() {
        assertDoesNotThrow(() -> {
            new CourseEnrollmentRequestBuilder().theCourse(course1).theStudent(student1).build();

            assertEquals(course1, courseEnrollmentRequest1.courseEnrollmentRequestCourse());
            assertEquals(student1, courseEnrollmentRequest1.courseEnrollmentRequestStudent());
        });
    }

    @Test
    public void testIfCourseEnrollmenteCourseIsCorrect() {
        assertEquals(course1, courseEnrollmentRequest1.courseEnrollmentRequestCourse());
        assertEquals(course2, courseEnrollmentRequest2.courseEnrollmentRequestCourse());
        assertNotEquals(course2, courseEnrollmentRequest1.courseEnrollmentRequestCourse());
    }

    @Test
    public void testIfCourseEnrollmenteStudentIsCorrect() {
        assertEquals(student1, courseEnrollmentRequest1.courseEnrollmentRequestStudent());
        assertEquals(student2, courseEnrollmentRequest2.courseEnrollmentRequestStudent());
        assertNotEquals(student2, courseEnrollmentRequest1.courseEnrollmentRequestStudent());
    }

    @Test
    public void testCourseEnrollmentRequest() {
        new CourseEnrollmentRequestBuilder().theCourse(course1).theStudent(student1).build();

        assertEquals(course1, courseEnrollmentRequest1.courseEnrollmentRequestCourse());
        assertEquals(student1, courseEnrollmentRequest1.courseEnrollmentRequestStudent());
    }

    @Test
    public void testEqualsCourseEnrollmentRequest() {

        assertTrue(courseEnrollmentRequest1.sameAs(courseEnrollmentRequest3));
    }

    @Test
    public void testNotEqualsRecurringLessons() {

        assertFalse(courseEnrollmentRequest1.sameAs(courseEnrollmentRequest2));
    }

}