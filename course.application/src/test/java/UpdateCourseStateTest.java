import eCourse.course.application.UpdateCourseStateController;
import eCourse.course.application.UpdateCourseStateService;
import eCourse.domain.Course;
import eCourse.domain.CourseBuilder;
import eCourse.domain.CourseEdition;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.usermanagement.domain.BaseCourseStates;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UpdateCourseStateTest {/*

    private String courseName = "Course 1";
    private String courseDescription = "Description 1";
    private String courseEdition = "2022-2023";


    private Course course = new CourseBuilder().descriptioned(Description.valueOf(courseDescription)).named(Designation.valueOf(courseName))
            .edition(CourseEdition.valueOf(courseEdition)).build();

    private UpdateCourseStateService service;

    @Test
    public void testIfDesignationIsCorrect() {
        String name1 = "Course 1";
        String name2 = "Course 2";

        Course course1 = new CourseBuilder().named(Designation.valueOf(name1)).build();
        Course course2 = new CourseBuilder().named(Designation.valueOf(name2)).build();

        assertEquals(name1, course1.designation().toString());
        assertEquals(name2, course2.designation().toString());
    }

    @Test
    public void testIfDescriptionIsCorrect() {
        String description1 = "Description 1";
        String description2 = "Description 2";

        Course course1 = new CourseBuilder().descriptioned(Description.valueOf(description1)).build();
        Course course2 = new CourseBuilder().descriptioned(Description.valueOf(description2)).build();

        assertEquals(description1, course1.description().toString());
        assertEquals(description2, course2.description().toString());
    }

    @Test
    public void testIfEditionIsCorrect() {
        String edition1 = "2022-2023";
        String edition2 = "2021-2022";

        Course course1 = new CourseBuilder().edition(CourseEdition.valueOf(edition1)).build();
        Course course2 = new CourseBuilder().edition(CourseEdition.valueOf(edition2)).build();

        assertEquals(edition1, course1.edition().toString());
        assertEquals(edition2, course2.edition().toString());
    }

    @Test
    public void testIfStateIsCorrect() {
        String state1 = "Close";
        String state2 = "Open";

        service.close(courseName);
        Course course1 = new CourseBuilder().wait(BaseCourseStates.valueOf(state1)).build();
        Course course2 = new CourseBuilder().wait(BaseCourseStates.valueOf(state2)).build();

        assertEquals(state1, course1.state().toString());
        assertEquals(state2, course2.state().toString());
    }

    @Test
    public void testIfCourseIsEqualToAnotherCourse() {
        Course course1 = new CourseBuilder().named(Designation.valueOf("Course 1")).build();
        Course course2 = new CourseBuilder().named(Designation.valueOf("Course 2")).build();
        Course course3 = new CourseBuilder().named(Designation.valueOf("Course 2")).build();

        assertTrue(course1.sameAs(course1));
        assertFalse(course1.sameAs(course2));
        assertTrue(course2.sameAs(course3));
    } */
}