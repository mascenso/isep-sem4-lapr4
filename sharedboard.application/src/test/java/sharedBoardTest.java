import eCourse.domain.CreateSharedBoardBuilder;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import org.junit.Test;
import static org.junit.Assert.*;



public class sharedBoardTest {

    private String title1 = "Shared Board 1";
    private String title2 = "Shared Board 2";
    private int columns1 = 3;
    private int columns2 = 5;
    private int rows1 = 2;
    private int rows2 = 4;
    private String owner1 = "admin";
    private String owner2 = "poweruser";

    private SharedBoard board1 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf(title1)).withNumberOfColumns(columns1)
            .withNumberOfRows(rows1).withArchive(false).withOwner(null).withColumns(null).withRows(null).build();

    private SharedBoard board2 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf(title2)).withNumberOfColumns(columns2)
            .withNumberOfRows(rows2).withArchive(false).withOwner(null).withColumns(null).withRows(null).build();

    @Test
    public void testIfTitleIsCorrect() {
        assertEquals(title1, board1.identity().toString());
        assertEquals(title2, board2.identity().toString());
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
        assertFalse(board2.archive());
    }

    @Test
    public void testIfSharedBoardIsEqualsToAnotherSharedBoard(){
        assertTrue(board1.sameAs(board1));
        assertFalse(board1.sameAs(board2));
    }


}
