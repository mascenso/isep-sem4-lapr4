import eCourse.domain.Course;
import eCourse.domain.CourseBuilder;
import eCourse.domain.CourseEdition;
import eCourse.domain.CourseStates;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.Test;

import static org.junit.Assert.*;

public class courseTest {

    private String name1 = "Course 1";
    private String name2 = "Course 2";
    private String description1 ="Description 1";
    private String description2 = "Description 2";
    private String edition1 = "2022-2023";
    private String edition2 = "2021-2022";
    private String state1 = "Open";
    private String state2 = "Close";

    private Course course1 = new CourseBuilder().descriptioned(Description.valueOf(description1)).named(Designation.valueOf(name1))
            .edition(CourseEdition.valueOf(edition1)).state(CourseStates.valueOf(state1)).build();
    private Course course2 = new CourseBuilder().descriptioned(Description.valueOf(description2)).named(Designation.valueOf(name2))
            .edition(CourseEdition.valueOf(edition2)).state(CourseStates.valueOf(state2)).build();
    private Course course3 = new CourseBuilder().descriptioned(Description.valueOf(description2)).named(Designation.valueOf(name2))
            .edition(CourseEdition.valueOf(edition2)).state(CourseStates.valueOf(state2)).build();


    @Test
    public void testIfDesignationIsCorrect() {
        assertEquals(name1, course1.designation().toString());
        assertEquals(name2, course3.designation().toString());
    }

    @Test
    public void testIfDescriptionIsCorrect() {
        assertEquals(description1, course1.description().toString());
        assertEquals(description2, course3.description().toString());
    }

    @Test
    public void testIfEditionIsCorrect() {
        assertEquals(edition1, course1.edition().toString());
        assertEquals(edition2, course3.edition().toString());
    }

    @Test
    public void testIfStateIsCorrect() {
        assertEquals(state1, course1.state().toString());
        assertEquals(state2, course3.state().toString());
    }

    @Test
    public void testIFCourseIsEqualToAnotherCourse() {
        assertTrue(course2.sameAs(course2));
        assertFalse(course2.sameAs(course3));
        assertFalse(course1.sameAs(course3));
    }
}
