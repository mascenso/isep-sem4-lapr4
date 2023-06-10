import eCourse.domain.*;

import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class SharedBoardUserTest {

    private SharedBoardUser sharedBoardUser1;
    private SharedBoardUser sharedBoardUser2;
    private SharedBoardUser sharedBoardUser3;
    private Role POWER_USER;
    private Role ADMIN;
    private Role TEACHER;
    private Set<Role> roles1 = new HashSet<>();
    private Set<Role> roles2 = new HashSet<>();
    private SystemUser owner;
    private SystemUser other;
    private SharedBoard board1;
    private SharedBoard board2;

    @BeforeEach
    public void setUp() {

        POWER_USER = Role.valueOf("POWER_USER");
        TEACHER = Role.valueOf("TEACHER");
        ADMIN = Role.valueOf("ADMIN");
        roles2.add(TEACHER);
        roles1.add(POWER_USER);
        roles1.add(ADMIN);
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        owner = userBuilder.with("owner", "Password1", "Harry", "Potter", "leviosa@mail.com").createdOn(CurrentTimeCalendars.now()).withRoles(roles1).build();
        other = userBuilder.with("other", "Password1", "Tom", "Riddle", "horcrux@mail.com").createdOn(CurrentTimeCalendars.now()).withRoles(roles2).build();

        board1 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Board 1")).withNumberOfColumns(1).withNumberOfRows(1).withArchive(false).withOwner(owner).withColumns(null).withRows(null).build();
        board2 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Board 2")).withNumberOfColumns(1).withNumberOfRows(1).withArchive(false).withOwner(other).withColumns(null).withRows(null).build();

    }

    @Test
    public void ensureCanShareOwnedBoard() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);

        assertNotNull(sharedBoardUser1);
    }

    @Test
    public void ensureUserIsRequired() {
        AccessType permission = AccessType.READ;
        assertThrows(IllegalArgumentException.class, () -> {
            SystemUser nullType = null;
            SharedBoardUser.valueOf(nullType, board1.boardTitle(), permission);
        });
    }

    @Test
    public void ensureBoardIDIsRequired() {
        AccessType permission = AccessType.READ;
        assertThrows(IllegalArgumentException.class, () -> {
            SharedBoardTitle nullType = null;
            SharedBoardUser.valueOf(owner, nullType, permission);
        });
    }

    @Test
    public void ensurePermissionIsRequired() {

        assertThrows(IllegalArgumentException.class, () -> {
            AccessType permission = null;
            SharedBoardUser.valueOf(other, board1.boardTitle(), permission);
        });
    }

    @Test
    public void ensureUserIsCorrect() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);

        assertEquals(owner, sharedBoardUser1.boardUser());
        assertEquals(other, sharedBoardUser2.boardUser());
        assertNotEquals(other, sharedBoardUser1.boardUser());
        assertNotEquals(owner, sharedBoardUser2.boardUser());
    }


    @Test
    public void ensureBoardIDIsCorrect() {
        AccessType permission = AccessType.READ;
        SharedBoardTitle title1=new SharedBoardTitle("Board 1");
        SharedBoardTitle title2=new SharedBoardTitle("Board 2");
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);

        assertEquals(title1, sharedBoardUser1.hasTitle());
        assertEquals(title2, sharedBoardUser2.hasTitle());
        assertNotEquals(title2, sharedBoardUser1.hasTitle());
        assertNotEquals(title1, sharedBoardUser2.hasTitle());
    }

    @Test
    public void ensurePermissionIsCorrect() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);

        assertEquals(AccessType.READ, sharedBoardUser1.hasPermission());
        assertEquals(AccessType.READ, sharedBoardUser2.hasPermission());
        assertNotEquals(AccessType.WRITE, sharedBoardUser1.hasPermission());
        assertNotEquals(AccessType.WRITE, sharedBoardUser2.hasPermission());
    }


    @Test
    public void ensureEqualsSharedBoardUser() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);
        sharedBoardUser3 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);

        assertTrue(sharedBoardUser1.sameAs(sharedBoardUser3));
        assertFalse(sharedBoardUser2.sameAs(sharedBoardUser3));
    }
}
