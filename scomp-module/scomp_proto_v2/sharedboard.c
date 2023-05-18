#include "sharedboard.h"
#include <stdio.h>

/* adds a new column to the board */
void addColumn(KanbanBoard* board, const char* columnName) {
    if (board->numColumns >= MAX_COLUMNS) {
        printf("Maximum number of columns reached.\n");
        return;
    }

    Column newColumn;
    snprintf(newColumn.name, sizeof(newColumn.name), "%s", columnName);
    newColumn.numCards = 0;

    board->columns[board->numColumns] = newColumn;
    board->numColumns++;
}

/* adds a new card to a column */
void addCard(KanbanBoard* board, int columnIndex, const char* cardTitle) {
    if (columnIndex < 0 || columnIndex >= board->numColumns) {
        printf("Invalid column index.\n");
        return;
    }

    Column* column = &board->columns[columnIndex];
    if (column->numCards >= MAX_CARDS) {
        printf("Maximum number of cards reached in this column.\n");
        return;
    }

    Card newCard;
    newCard.id = column->numCards + 1;
    snprintf(newCard.title, sizeof(newCard.title), "%s", cardTitle);

    column->cards[column->numCards] = newCard;
    column->numCards++;
}

/* Move a card from one column to another */
void moveCard(KanbanBoard* board, int sourceColumnIndex, int destinationColumnIndex, int cardIndex) {
    if (sourceColumnIndex < 0 || sourceColumnIndex >= board->numColumns ||
        destinationColumnIndex < 0 || destinationColumnIndex >= board->numColumns) {
        printf("Invalid column index.\n");
        return;
    }

    Column* sourceColumn = &board->columns[sourceColumnIndex];
    Column* destinationColumn = &board->columns[destinationColumnIndex];

    if (cardIndex < 0 || cardIndex >= sourceColumn->numCards) {
        printf("Invalid card index.\n");
        return;
    }

    Card card = sourceColumn->cards[cardIndex];

    // Remove the card from the source column
    for (int i = cardIndex; i < sourceColumn->numCards - 1; i++) {
        sourceColumn->cards[i] = sourceColumn->cards[i + 1];
    }
    sourceColumn->numCards--;

    // Add the card to the destination column
    destinationColumn->cards[destinationColumn->numCards] = card;
    destinationColumn->numCards++;
}

/* Prints the board */
void displayBoard(KanbanBoard* board) {
    printf("Kanban Board:\n");

    for (int i = 0; i < board->numColumns; i++) {
        const Column* column = &board->columns[i];

        printf("Column: %s\n", column->name);
        printf("--------------------\n");

        if (column->numCards == 0) {
            printf("No cards in this column.\n");
        } else {
            for (int j = 0; j < column->numCards; j++) {
                const Card* card = &column->cards[j];
                printf("Card #%d: %s\n", card->id, card->title);
            }
        }

        printf("\n");
    }
}
