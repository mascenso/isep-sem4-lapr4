//
// Created by mariana on 11/05/23.
//

#ifndef SCOMP22232NBG03_SHAREDBOARD_H
#define SCOMP22232NBG03_SHAREDBOARD_H

#define MAX_COLUMNS 10
#define MAX_CARDS 100

// Structure to represent a card
typedef struct {
    int id;
    char title[50];
} Card;

// Structure to represent a column
typedef struct {
    char name[50];
    Card cards[MAX_CARDS];
    int numCards;
} Column;

// Structure to represent the Kanban board
typedef struct {
    Column columns[MAX_COLUMNS];
    int numColumns;
} KanbanBoard;

// Function to add a new column to the board
void addColumn(KanbanBoard* board, const char* columnName);

// Function to add a new card to a specific column
void addCard(KanbanBoard* board, int columnIndex, const char* cardTitle);

// Function to move a card from one column to another
void moveCard(KanbanBoard* board, int sourceColumnIndex, int destinationColumnIndex, int cardIndex);

// Function to display the board
void displayBoard(KanbanBoard* board);

#endif //SCOMP22232NBG03_SHAREDBOARD_H
