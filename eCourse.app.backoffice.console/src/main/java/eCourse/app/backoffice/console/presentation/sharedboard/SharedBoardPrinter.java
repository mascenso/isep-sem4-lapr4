package eCourse.app.backoffice.console.presentation.sharedboard;

import eCourse.domain.Colunas;
import eCourse.domain.Linhas;
import eCourse.domain.SharedBoard;


public class SharedBoardPrinter {

    public void print(SharedBoard sharedBoard) {
        System.out.printf("SharedBoard \"%s\" owned by %s\n", sharedBoard.getTitle(), sharedBoard.getOwner());

        final int numberOfRows = sharedBoard.getLinhas().size();
        final int numberOfColumns = sharedBoard.getColunas().size();

        // Imprime números de colunas
        System.out.print("  |");
        for (Colunas column : sharedBoard.getColunas()) {
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
            Linhas row = sharedBoard.getLinhas().get(i - 1);
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
