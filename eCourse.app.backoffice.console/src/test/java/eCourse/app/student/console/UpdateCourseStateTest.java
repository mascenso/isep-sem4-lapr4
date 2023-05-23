package eCourse.app.student.console;

import eCourse.course.application.CreateCourseController;
import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.Course;
import eCourse.domain.CourseState;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.BaseCourseStates;
import eCourse.usermanagement.domain.ECoursePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.*;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UpdateCourseStateTest {

    private static Optional<UserSession> session;
    private static Role onlyWithThis;
    private static Course teste1;


    @BeforeClass
    public static void setupTests() {
        System.out.println("BeforeClass");
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
                new PlainTextEncoder());
        AuthenticationService authenticationService = AuthzRegistry.authenticationService();
        boolean present = authenticationService.authenticate("poweruser", "poweruserA1", onlyWithThis).isPresent();

        teste1 = new CreateCourseController().createCourse("curso1", "2023","curso description");
        //Course course2 = new CreateCourseController().createCourse("curso2", "2023","curso description1");


    }

    @AfterClass
    public static void cleanUpTests() {
        PersistenceContext.repositories().courses().delete(teste1);
        System.out.println("AfterClass");
    }


    @Before
    public void init() {
        //runs before all test methods
        System.out.println("init");

    }

    @After
    public void teardown() {
        //runs after all test methods
        System.out.println("teardown");
    }


    @Test
    public void testUpdateToOpenWhenIsClosed() {

        System.out.println("testUpdateToOpenWhenIsClosed");

        //setup test / params
        UpdateCourseStateController paramUpdateController = new UpdateCourseStateController();
       // String paramDesignationName = "Informatica";
        Course paramCourse = teste1;
        String paramNewState = BaseCourseStates.OPEN.toString();

        //expected result
        CourseState expectedNewState = BaseCourseStates.OPEN;
        Boolean expectedHasExceptions = false;

        //actual result
        Optional<Course> actualCourseOptional = null;
        Course actualCourse = null;
        boolean actualHasExceptions = false;
        try {
            paramUpdateController.updateCourseState(paramCourse.identity().toString(), paramNewState);

        } catch (Exception e) {
            actualHasExceptions = true;
        }

        actualCourseOptional = paramUpdateController.findCourseByDesignation(paramCourse.identity().toString());
        actualCourse = actualCourseOptional.get();
        //asset the expected with the actual
        //FIXME
        //assertEquals("Assert if there is no exceptions", expectedHasExceptions, actualHasExceptions);
        assertNotNull(actualCourse);
        assertEquals("Assert if new state is open", expectedNewState, actualCourse.getCourseState());
    }

    @Test
    public void testMethod02() {
        //...
        System.out.println("testMethod02");

        //setup test / params
        //expected result
        //actual result

        //→ asset (expected, actual)

    }


}


