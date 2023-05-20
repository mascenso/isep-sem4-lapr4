package eCourse.clientusermanagement.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

/**
 * Created by Nuno Bettencourt [NMB] on 03/04/16.
 */
public class ClientUserTest {

    private final String aMecanographicNumber = "abc";
    private final String anotherMecanographicNumber = "xyz";

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
    public void ensureClientUserEqualsPassesForTheSameMecanographicNumber() throws Exception {

        final ClientUser aClientUser = new ClientUserBuilder().withMecanographicNumber("DUMMY")
                .withSystemUser(getNewDummyUser()).build();

        final ClientUser anotherClientUser = new ClientUserBuilder().withMecanographicNumber("DUMMY")
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aClientUser.equals(anotherClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureClientUserEqualsFailsForDifferenteMecanographicNumber() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final ClientUser aClientUser = new ClientUserBuilder().withMecanographicNumber(aMecanographicNumber)
                .withSystemUser(getNewDummyUser()).build();

        final ClientUser anotherClientUser = new ClientUserBuilder()
                .withMecanographicNumber(anotherMecanographicNumber).withSystemUser(getNewDummyUser()).build();

        final boolean expected = aClientUser.equals(anotherClientUser);

        assertFalse(expected);
    }

    @Test
    public void ensureClientUserEqualsAreTheSameForTheSameInstance() throws Exception {
        final ClientUser aClientUser = new ClientUser();

        final boolean expected = aClientUser.equals(aClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureClientUserEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);

        final ClientUser aClientUser = new ClientUserBuilder().withMecanographicNumber("DUMMY")
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aClientUser.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureClientUserIsTheSameAsItsInstance() throws Exception {
        final ClientUser aClientUser = new ClientUserBuilder().withMecanographicNumber("DUMMY")
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = aClientUser.sameAs(aClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoClientUserWithDifferentMecanographicNumbersAreNotTheSame() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.ADMIN);
        final ClientUser aClientUser = new ClientUserBuilder().withMecanographicNumber(aMecanographicNumber)
                .withSystemUser(getNewDummyUser()).build();

        final ClientUser anotherClientUser = new ClientUserBuilder()
                .withMecanographicNumber(anotherMecanographicNumber).withSystemUser(getNewDummyUser()).build();

        final boolean expected = aClientUser.sameAs(anotherClientUser);

        assertFalse(expected);
    }
}
