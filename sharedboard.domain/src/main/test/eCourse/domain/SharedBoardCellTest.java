package eCourse.domain;

import eCourse.domain.enums.AccessType;
import eCourse.domain.postit.PostIt;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SharedBoardCellTest {


    List<SBRow> linhas = new ArrayList<>();
    List<SBColumn> colunas = new ArrayList<>();

    List<SBRow> linhas2 = new ArrayList<>();
    List<SBColumn> colunas2 = new ArrayList<>();

    SharedBoardTitle title = new SharedBoardTitle("Teste");

    AccessType accessType = AccessType.WRITE;

    public static SystemUser dummyUser(final String username, final Role roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }


    @BeforeEach
    private void setUp() {
        colunas.add(new SBColumn("Todo"));
        colunas.add(new SBColumn("Doing"));
        colunas.add(new SBColumn("Done"));

        colunas2.add(new SBColumn("Testing"));
        colunas2.add(new SBColumn("Ta La Quase"));

        linhas.add(new SBRow("Linha1"));
        linhas.add(new SBRow("Linha2"));
        linhas.add(new SBRow("Linha3"));
        linhas2.add(new SBRow("LinhaA"));
        linhas2.add(new SBRow("LinhaB"));
    }


    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", ECourseRoles.TEACHER);
    }



    @Test
    public void testAddPostIt() {
    //public SharedBoard(final SharedBoardTitle title, int numberColumns, int numberRows, boolean archive, final SystemUser owner, List<SBColumn> columns, List<SBRow> rows) {
    }

    @Test
    public void testChangePostItContent() {
        // Create necessary objects for the test
        SharedBoard matrix = new SharedBoard(title, 3, 3, false, getNewDummyUser(), colunas, linhas);
        Position position = new Position(1, 1);
        SharedBoardCell cell = new SharedBoardCell(matrix, position);
        PostIt postIt = new PostIt("Initial content");
        cell.addPostIt(postIt, new SharedBoardUser());

        // Perform the action
        cell.changePostItContent("New content");

        // Assertions
        Assertions.assertEquals(new PostIt("New content"), cell.content().get());
    }

    @Test
    public void testIsFree() {
        // Create necessary objects for the test
        SharedBoard matrix = new SharedBoard(title, 3, 3, false, getNewDummyUser(), colunas, linhas);
        Position position = new Position(1, 1);
        SharedBoardCell cell = new SharedBoardCell(matrix, position);

        // Assertions
        Assertions.assertTrue(cell.isFree());

        // Add a post-it to the cell
        cell.addPostIt(new PostIt(), new SharedBoardUser());

        // Assertions
        Assertions.assertFalse(cell.isFree());
    }

    @Test
    public void testSameAs() {
        SharedBoard matrix = new SharedBoard(title, 3, 3, false, getNewDummyUser(), colunas, linhas);

        // Create shared board cells
        SharedBoardCell cell1 = matrix.cellWithPosition(new Position(1, 1));
        SharedBoardCell cell2 = matrix.cellWithPosition(new Position(1, 1));
        SharedBoardCell cell3 = matrix.cellWithPosition(new Position(1, 2));

        // Same identity
        Assertions.assertTrue(cell1.sameAs(cell2));

        // Different identity
        Assertions.assertFalse(cell1.sameAs(cell3));

    }


}