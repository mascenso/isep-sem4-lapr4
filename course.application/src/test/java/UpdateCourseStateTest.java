import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.Course;
import eCourse.domain.CourseBuilder;
import eCourse.domain.CourseEdition;
import eCourse.usermanagement.domain.BaseCourseStates;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UpdateCourseStateTest {

    private String courseName = "Course 1";
    private String courseDescription = "Description 1";
    private String courseEdition = "2022-2023";

    private Course course = new CourseBuilder().descriptioned(Description.valueOf(courseDescription)).named(Designation.valueOf(courseName))
            .edition(CourseEdition.valueOf(courseEdition)).build();

    private UpdateCourseStateController courseStateController;

    @BeforeEach
    public void setup() {
        Designation name = Designation.valueOf(courseName);
        Description description = Description.valueOf(courseDescription);
        CourseEdition edition = CourseEdition.valueOf(courseEdition);

        courseStateController = new UpdateCourseStateController();
    }

    @Test
    public void testOpenCourse() {
        String newState = "Open";

        courseStateController.updateCourseState(courseName, newState);

        assertEquals(BaseCourseStates.CLOSE.getActualState(), course.state().getActualState());
    }

    @Test
    public void testCloseCourse() {
        String newState = "Close";

        courseStateController.updateCourseState(courseName, newState);

        assertEquals(BaseCourseStates.CLOSE.getActualState(), course.state().getActualState());
    }
}