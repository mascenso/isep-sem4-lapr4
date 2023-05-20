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

// Structure to represent the Shared board
typedef struct {
    Column columns[MAX_COLUMNS];
    int numColumns;
} SharedBoard;

// Function to add a new column to the board
void addColumn(SharedBoard* board, const char* columnName);

// Function to add a new card to a specific column
void addCard(SharedBoard* board, int columnIndex, const char* cardTitle);

// Function to move a card from one column to another
void moveCard(SharedBoard* board, int sourceColumnIndex, int destinationColumnIndex, int cardIndex);

// Function to display the board
void displayBoard(SharedBoard* board);

#endif //SCOMP22232NBG03_SHAREDBOARD_H
