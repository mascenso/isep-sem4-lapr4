package eCourse.studentusermanagement.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import eCourse.usermanagement.application.ECourseRoles;
import org.junit.Test;

import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

/**
 * Created by Nuno Bettencourt [NMB] on 03/04/16.
 */
public class StudentUserTest {

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
    public void ensureStudentUserEqualsPassesForTheSameMecanographicNumber() throws Exception {

        final StudentUser aStudentUser = new StudentUserBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.STUDENT), aMecanographicNumber);

        final StudentUser anotherStudentUser = new StudentUserBuilder()
                .withSystemUser(getNewDummyUser()).build(dummyUser("dummy", ECourseRoles.STUDENT), aMecanographicNumber);

        final boolean expected = aStudentUser.equals(anotherStudentUser);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentUserEqualsFailsForDifferenteMecanographicNumber() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final StudentUser aStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final StudentUser anotherStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(anotherMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudentUser.equals(anotherStudentUser);

        assertFalse(expected);
    }

    @Test
    public void ensureStudentUserEqualsAreTheSameForTheSameInstance() throws Exception {
        final StudentUser aStudentUser = new StudentUser();

        final boolean expected = aStudentUser.equals(aStudentUser);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentUserEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final StudentUser aStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudentUser.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureStudentUserIsTheSameAsItsInstance() throws Exception {
        final StudentUser aStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudentUser.sameAs(aStudentUser);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoStudentUserWithDifferentMecanographicNumbersAreNotTheSame() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);
        final StudentUser aStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(aMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final StudentUser anotherStudentUser = new StudentUserBuilder()
                .withMecNumber(new MecanographicNumber(anotherMecanographicNumber))
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aStudentUser.sameAs(anotherStudentUser);

        assertFalse(expected);
    }
}
