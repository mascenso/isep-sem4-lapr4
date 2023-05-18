#include "sharedboard.h"

int main() {

    SharedBoard board;
    board.numColumns = 0;

    // Add some initial columns
    addColumn(&board, "To Do");
    addColumn(&board, "In Progress");
    addColumn(&board, "Done");

    // Add cards to the first column
    addCard(&board, 0, "Task 1");
    addCard(&board, 0, "Task 2");
    addCard(&board, 0, "Task 3");

    // Add cards to the second column
    addCard(&board, 1, "Task 4");

    // Move a card from the first column to the third column
    moveCard(&board, 0, 2, 0);

    // Display the board
    displayBoard(&board);

    return 0;
}

