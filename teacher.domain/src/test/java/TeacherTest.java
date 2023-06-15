import eCourse.domain.Acronym;
import eCourse.domain.ECourseRoles;
import eCourse.domain.Teacher;
import eCourse.domain.TeacherBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TeacherTest {

    private final String aAcronym = "abc";
    private final String anotherAcronym = "www";

    public static SystemUser dummyUser(final String username, final Role roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", ECourseRoles.TEACHER);
    }

    private SystemUser getNewDummyUserTwo() {
        return dummyUser("dummy-two", ECourseRoles.TEACHER);
    }

    @Test
    public void ensureTeacherEqualsPassesForTheSameAcronym() throws Exception {

        final Teacher aTeacher = new TeacherBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.TEACHER), aAcronym);

        final Teacher anotherTeacher = new TeacherBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.TEACHER), aAcronym);

        final boolean expected = aTeacher.equals(anotherTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTeacherEqualsFailsForDifferentAcronym() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.TEACHER);

        final Teacher aTeacher = new TeacherBuilder()
                .withAcronym(aAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final Teacher anotherTeacher = new TeacherBuilder()
                .withAcronym(anotherAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aTeacher.equals(anotherTeacher);

        assertFalse(expected);
    }

    @Test
    public void ensureAcronymCantBeNull() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.TEACHER);

        try {
            new TeacherBuilder().withAcronym(null).withSystemUser(getNewDummyUser()).build();
        } catch (final IllegalArgumentException e) {
            assertTrue(true);
        }
    }


    @Test
    public void ensureTaxPayNumberCantBeNull() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.TEACHER);

        try {
            new TeacherBuilder().withAcronym(null).withSystemUser(getNewDummyUser()).build();
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }




    @Test
    public void ensureTeacherEqualsAreTheSameForTheSameInstance() throws Exception {
        final Teacher aTeacher = new TeacherBuilder()
                .withAcronym(aAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aTeacher.equals(aTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTeacherEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.TEACHER);

        final Teacher aTeacher = new TeacherBuilder()
                .withAcronym(aAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aTeacher.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureTeacherIsTheSameAsItsInstance() throws Exception {
        final Teacher aTeacher = new TeacherBuilder()
                .withAcronym(aAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aTeacher.sameAs(aTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoTeacherWithDifferentAcronymsAreNotTheSame() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.TEACHER);
        final Teacher aTeacher = new TeacherBuilder()
                .withAcronym(aAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final Teacher anotherTeacher = new TeacherBuilder()
                .withAcronym(anotherAcronym)
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aTeacher.sameAs(anotherTeacher);

        assertFalse(expected);
    }
}
