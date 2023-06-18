import eCourse.domain.*;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


public class SharedBoardTest {

    private SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

    private Role POWER_USER = Role.valueOf("POWER_USER");
    private Role ADMIN = Role.valueOf("TEACHER");
    private Role TEACHER = Role.valueOf("ADMIN");
    private Set<Role> roles1 = new HashSet<>();
    private Set<Role> roles2 = new HashSet<>();
    private SystemUser owner = userBuilder.with("owner", "Password1", "Harry", "Potter", "leviosa@mail.com").createdOn(CurrentTimeCalendars.now()).withRoles(roles1).build();
    private SystemUser other = userBuilder.with("other", "Password1", "Tom", "Riddle", "horcrux@mail.com").createdOn(CurrentTimeCalendars.now()).withRoles(roles2).build();
    private List<SBColumn> columnList = new ArrayList<>();
    private List<SBRow> rowList = new ArrayList<>();
    private int columns1 = 3;
    private int columns2 = 2;
    private int rows1 = 1;
    private int rows2 = 3;
    private SharedBoardTitle title1 = SharedBoardTitle.valueOf("Board 1");
    private SharedBoardTitle title2 = SharedBoardTitle.valueOf("Board 2");
    private SharedBoard board1 = new CreateSharedBoardBuilder().withTitle(title1).withNumberOfColumns(3).withNumberOfRows(1).withArchive(false).withOwner(owner).withColumns(columnList).withRows(rowList).build();
    private SharedBoard board2 = new CreateSharedBoardBuilder().withTitle(title2).withNumberOfColumns(2).withNumberOfRows(3).withArchive(true).withOwner(other).withColumns(columnList).withRows(rowList).build();
    private SharedBoard board3 = new CreateSharedBoardBuilder().withTitle(title2).withNumberOfColumns(1).withNumberOfRows(2).withArchive(false).withOwner(owner).withColumns(columnList).withRows(rowList).build();


    @BeforeEach
    public void setUp() {
        columnList.add(new SBColumn("C"));
        rowList.add(new SBRow("R"));
        rowList.add(new SBRow("O"));
        rowList.add(new SBRow("W"));

    }

    @Test
    public void testIfTitleIsCorrect() {
        assertEquals(title1, board1.boardTitle());
        assertEquals(title2, board2.boardTitle());
    }


    @Test
    public void testIfNumberOfColumnsIsCorrect() {
        assertEquals(columns1, board1.numberOfColumns());
        assertEquals(columns2, board2.numberOfColumns());
    }

    @Test
    public void testIfNumberOfRowsIsCorrect() {
        assertEquals(rows1, board1.numberOfRows());
        assertEquals(rows2, board2.numberOfRows());
    }

    @Test
    public void testIfArchiveIsCorrect() {
        assertFalse(board1.archive());
        assertTrue(board2.archive());
    }

    @Test
    public void testIfSharedBoardIsEqualsToAnotherSharedBoard() {
        assertTrue(board1.sameAs(board1));
        assertFalse(board1.sameAs(board2));
    }


    @Test
    public void ensureBoardOwnerIsCorrect() {
        assertTrue(board1.owner().sameAs(owner));
        assertTrue(board2.owner().sameAs(other));
        assertFalse(board2.owner().sameAs(owner));
        assertFalse(board1.owner().sameAs(other));

    }

    @Test
    public void testOnlyOwnerCanArchiveBoard() {
        // A board nao está arquivada
        assertFalse(board3.archive());

        // Outro utilizador tenta aquivar
        assertFalse(board3.updateArchive(true, other));

        // Owner archives the board
        assertTrue(board3.updateArchive(true, owner));

        //Verifica que a board foi arquivada
        assertTrue(board3.archive());
    }


    @Test
    public void testCannotArchiveAlreadyArchivedBoard() {
        // Board arquivada
        board1.updateArchive(true,owner);
        assertTrue(board1.archive());

        // Tenta alterar para false o arquivo da board já arquivada
        board1.updateArchive(false,owner);
        assertTrue(board1.archive()); // Board should still be archived
    }
}
