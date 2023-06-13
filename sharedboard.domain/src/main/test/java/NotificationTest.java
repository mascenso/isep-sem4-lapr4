import eCourse.domain.*;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {

    private Notification notification1;
    private Notification notification2;
    private BoardShareEvent boardShareEvent1;
    private BoardShareEvent boardShareEvent2;

    private SharedBoardUser sharedBoardUser1;
    private SharedBoardUser sharedBoardUser2;
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
    public void ensureEventCannotBeNull() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        boardShareEvent1 = new BoardShareEvent(sharedBoardUser1);
        notification1 = new Notification(boardShareEvent1);

        assertNotNull(boardShareEvent1);
        assertNotNull(notification1);
    }

    @Test
    public void ensureUserIsCorrect() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);
        boardShareEvent1 = new BoardShareEvent(sharedBoardUser1);
        boardShareEvent2 = new BoardShareEvent(sharedBoardUser2);
        notification1 = new Notification(boardShareEvent1);
        notification2 = new Notification(boardShareEvent2);

        assertEquals(owner, notification1.user());
        assertEquals(other, notification2.user());
        assertNotEquals(other, notification1.user());
        assertNotEquals(owner, notification2.user());
    }

    @Test
    public void ensureTitleIsCorrect() {
        AccessType permission = AccessType.READ;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission);
        boardShareEvent1 = new BoardShareEvent(sharedBoardUser1);
        boardShareEvent2 = new BoardShareEvent(sharedBoardUser2);
        notification1 = new Notification(boardShareEvent1);
        notification2 = new Notification(boardShareEvent2);

        assertEquals(board2.boardTitle(), notification2.title());
        assertEquals(board1.boardTitle(), notification1.title());
        assertNotEquals(board2.boardTitle(), notification1.title());
        assertNotEquals(board1.boardTitle(), notification2.title());
    }

    @Test
    public void ensurePermissionIsCorrect() {
        AccessType permission1 = AccessType.READ;
        AccessType permission2 = AccessType.WRITE;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission1);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission2);
        boardShareEvent1 = new BoardShareEvent(sharedBoardUser1);
        boardShareEvent2 = new BoardShareEvent(sharedBoardUser2);
        notification1 = new Notification(boardShareEvent1);
        notification2 = new Notification(boardShareEvent2);

        assertEquals(sharedBoardUser2.hasPermission(), notification2.permission());
        assertEquals(sharedBoardUser1.hasPermission(), notification1.permission());
        assertNotEquals(sharedBoardUser1.hasPermission(), notification2.permission());
        assertNotEquals(sharedBoardUser2.hasPermission(), notification1.permission());
    }


}
