import eCourse.domain.Course;
import eCourse.domain.CourseBuilder;
import eCourse.domain.CourseEdition;
import eCourse.domain.CourseState;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UpdateCourseStateTest {

    private String name1 = "Course 1";
    private String description1 ="Description 1";
    private String edition1 = "2022-2023";
    private String state1 = "Close";

    private Course course = new CourseBuilder().descriptioned(Description.valueOf(description1)).named(Designation.valueOf(name1))
            .edition(CourseEdition.valueOf(edition1)).build();

    @Test
    public void testUpdateCourseState() {
        CourseState state = CourseState.valueOf("Open");
        assertEquals(course.state().toString(),"Close");
        course.updateState(state);
        assertEquals(course.state().toString(),"Open");
    }
}