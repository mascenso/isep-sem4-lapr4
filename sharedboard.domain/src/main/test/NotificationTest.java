import eCourse.domain.*;
import eCourse.domain.enums.AccessType;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {

    private Notification notification1;
    private Notification notification2;
    private Notification notification3;
    private BoardShareEvent boardShareEvent1;
    private BoardShareEvent boardShareEvent2;
    private BoardUpdateEvent boardUpdateEvent1;
    private BoardUpdateEvent boardUpdateEvent2;

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
    private SharedBoard board3;

    private List<SBColumn> columnList=new ArrayList<>();
    private List<SBRow> rowList=new ArrayList<>();



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

        columnList.add(new SBColumn("C"));
        rowList.add(new SBRow("R"));

        board1 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Board 1")).withNumberOfColumns(1).withNumberOfRows(1).withArchive(false).withOwner(owner).withColumns(columnList).withRows(rowList).build();
        board2 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Board 2")).withNumberOfColumns(2).withNumberOfRows(2).withArchive(false).withOwner(other).withColumns(columnList).withRows(rowList).build();
        board3 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Board 3")).withNumberOfColumns(2).withNumberOfRows(2).withArchive(true).withOwner(other).withColumns(columnList).withRows(rowList).build();

    }

    @Test
    public void ensureShareEventCannotBeNull() {

        assertThrows(NullPointerException.class, () -> {
            SharedBoardUser nullType = null;
            new BoardShareEvent(nullType);
        });
    }

    @Test
    public void ensureUserCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            SystemUser nullType = null;
            new BoardUpdateEvent(board1,nullType);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BoardShareEvent nullType = null;
            new Notification(nullType);
        });

    }

    @Test
    public void ensureUpdateEventCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            BoardUpdateEvent nullType = null;
            new Notification(nullType,owner);
        });

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

    @Test
    public void ensureNumberOfColumnsIsCorrect() {

        boardUpdateEvent1 = new BoardUpdateEvent(board1, owner);
        boardUpdateEvent2 = new BoardUpdateEvent(board2, other);
        notification1 = new Notification(boardUpdateEvent1, owner);
        notification2 = new Notification(boardUpdateEvent2, other);

        assertEquals(board1.numberOfColumns(), notification1.numberOfColumns());
        assertEquals(board2.numberOfColumns(), notification2.numberOfColumns());
        assertNotEquals(board2.numberOfColumns(), notification1.numberOfColumns());
        assertNotEquals(board1.numberOfColumns(), notification2.numberOfColumns());

    }


    @Test
    public void ensureNumberOfRowsIsCorrect() {

        boardUpdateEvent1 = new BoardUpdateEvent(board1, owner);
        boardUpdateEvent2 = new BoardUpdateEvent(board2, other);
        notification1 = new Notification(boardUpdateEvent1, owner);
        notification2 = new Notification(boardUpdateEvent2, other);

        assertEquals(board1.numberOfRows(), notification1.numberOfRows());
        assertEquals(board2.numberOfRows(), notification2.numberOfRows());
        assertNotEquals(board2.numberOfRows(), notification1.numberOfRows());
        assertNotEquals(board1.numberOfRows(), notification2.numberOfRows());

    }


    @Test
    public void ensureArchiveIsCorrect() {

        boardUpdateEvent1 = new BoardUpdateEvent(board1, owner);
        boardUpdateEvent2 = new BoardUpdateEvent(board2, other);
        notification1 = new Notification(boardUpdateEvent1, owner);
        notification2 = new Notification(boardUpdateEvent2, other);

        assertEquals(board1.archive(), notification1.archive());
        assertEquals(board2.archive(), notification2.archive());
        assertNotEquals(board3.archive(), notification1.archive());
        assertNotEquals(board3.archive(), notification2.archive());

    }


    @Test
    public void ensureOwnerIsCorrect() {

        boardUpdateEvent1 = new BoardUpdateEvent(board1, owner);
        boardUpdateEvent2 = new BoardUpdateEvent(board2, other);
        notification1 = new Notification(boardUpdateEvent1, owner);
        notification2 = new Notification(boardUpdateEvent2, other);

        assertEquals(board1.owner(), notification1.owner());
        assertEquals(board2.owner(), notification2.owner());
        assertNotEquals(board2.owner(), notification1.owner());
        assertNotEquals(board1.owner(), notification2.owner());

    }

    @Test
    public void ensureSameUpdateNotification() {

        boardUpdateEvent1 = new BoardUpdateEvent(board1, owner);
        boardUpdateEvent2 = new BoardUpdateEvent(board2, other);
        notification1 = new Notification(boardUpdateEvent1, owner);
        notification2 = new Notification(boardUpdateEvent2, other);
        notification3 = new Notification(boardUpdateEvent1, owner);

        assertTrue(notification1.sameAs(notification3));
        assertFalse(notification1.sameAs(notification2));
        assertFalse(notification2.sameAs(notification3));
    }

    @Test
    public void ensureSameSharedNotification() {
        AccessType permission1 = AccessType.READ;
        AccessType permission2 = AccessType.WRITE;
        sharedBoardUser1 = board1.createShareBoardUsers(owner, board1.boardTitle(), permission1);
        sharedBoardUser2 = board2.createShareBoardUsers(other, board2.boardTitle(), permission2);
        boardShareEvent1 = new BoardShareEvent(sharedBoardUser1);
        boardShareEvent2 = new BoardShareEvent(sharedBoardUser2);
        notification1 = new Notification(boardShareEvent1);
        notification2 = new Notification(boardShareEvent2);
        notification3 = new Notification(boardShareEvent1);

        assertTrue(notification1.sameAs(notification3));
        assertFalse(notification1.sameAs(notification2));
        assertFalse(notification2.sameAs(notification3));
    }


}
