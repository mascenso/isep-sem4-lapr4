import eCourse.course.application.UpdateCourseStateController;
import eCourse.course.application.UpdateCourseStateService;
import eCourse.domain.Course;
import eCourse.domain.CourseBuilder;
import eCourse.domain.CourseEdition;
import eCourse.domain.CourseState;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eCourse.usermanagement.domain.BaseCourseStates;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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