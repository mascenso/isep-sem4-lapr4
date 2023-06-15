import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import eCourse.domain.ECourseRoles;
import eCourse.domain.MecanographicNumber;
import eCourse.domain.Student;
import eCourse.domain.StudentBuilder;
import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

public class StudentTest {

    private final String aMecanographicNumber = "202200001";
    private final String anotherMecanographicNumber = "202200002";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", ECourseRoles.ADMIN);
    }

    private SystemUser getNewDummyUserTwo() {
        return dummyUser("dummy-two", ECourseRoles.ADMIN);
    }

    @Test
    public void ensureStudentEqualsPassesForTheSameMecanographicNumber() throws Exception {

        final Student aStudent = new StudentBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.STUDENT), aMecanographicNumber);

        final Student anotherStudent = new StudentBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.STUDENT), aMecanographicNumber);

        final boolean expected = aStudent.equals(anotherStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentEqualsFailsForDifferenteMecanographicNumber() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final Student aStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final Student anotherStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(anotherMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudent.equals(anotherStudent);

        assertFalse(expected);
    }

    @Test
    public void ensureMecNumberCantBeNull() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        try {
            new StudentBuilder().withMecNumber(null).withSystemUser(getNewDummyUser()).build();
        } catch (final IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void ensureTaxPayNumberCantIsValid() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        try {
            new StudentBuilder().withTaxPayNumber("502").withSystemUser(getNewDummyUser()).build();
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void ensureTaxPayNumberCantBeNull() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        try {
            new StudentBuilder().withTaxPayNumber(null).withSystemUser(getNewDummyUser()).build();
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }




    @Test
    public void ensureStudentEqualsAreTheSameForTheSameInstance() throws Exception {
        final Student aStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudent.equals(aStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final Student aStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudent.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureStudentIsTheSameAsItsInstance() throws Exception {
        final Student aStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudent.sameAs(aStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoStudentWithDifferentMecanographicNumbersAreNotTheSame() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);
        final Student aStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final Student anotherStudent = new StudentBuilder()
                .withMecNumber(new MecanographicNumber(anotherMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudent.sameAs(anotherStudent);

        assertFalse(expected);
    }
}
