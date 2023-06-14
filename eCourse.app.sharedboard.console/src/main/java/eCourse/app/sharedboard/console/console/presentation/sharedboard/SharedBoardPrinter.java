package eCourse.app.sharedboard.console.console.presentation.sharedboard;

import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eCourse.domain.SharedBoard;


public class SharedBoardPrinter {

    public void print(SharedBoard sharedBoard) {
        System.out.printf("SharedBoard \"%s\" owned by %s\n", sharedBoard.title(), sharedBoard.owner());

        final int numberOfRows = sharedBoard.linhas().size();
        final int numberOfColumns = sharedBoard.colunas().size();

        // Imprime números de colunas
        System.out.print("  |");
        for (SBColumn column : sharedBoard.colunas()) {
            System.out.printf(" %s |", column.getName());
        }
        System.out.println();

        // Imprime separador
        System.out.print("--|");
        for (int i = 0; i < numberOfColumns; i++) {
            System.out.print("---|");
        }
        System.out.println();

        // Imprime números de linhas e células
        for (int i = 1; i <= numberOfRows; i++) {
            SBRow row = sharedBoard.linhas().get(i - 1);
            System.out.printf("%2d|", i);

            System.out.println();
            System.out.print("--|");
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print("---|");
            }
            System.out.println();
        }
    }
}
