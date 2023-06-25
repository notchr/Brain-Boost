// Brain Boost

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_NAME_LENGTH 32
#define MAX_ARRAY_SIZE 48

// Data structure for a single game level
typedef struct GameLevel {
    int numRows;
    int numCols;
    char board[MAX_ARRAY_SIZE][MAX_ARRAY_SIZE];
} GameLevel;

// Data structure for a single player profile
typedef struct Player {
    char name[MAX_NAME_LENGTH];
    int score;
    int level; 
} Player;

// Function prototypes
void generateBoard(GameLevel *level);
void printBoard(GameLevel *level);
void updateScore(Player *player, GameLevel *level);

int main(void) {
    Player player;
    // Initialize player name
    printf("Please enter your name: ");
    scanf("%s", player.name);
    
    // Initialize player score and current level
    player.score = 0;
    player.level = 1;
    
    // Generate a game board and print it out
    GameLevel currentLevel;
    generateBoard(&currentLevel);
    printBoard(&currentLevel);
    
    // Update the score and print it out
    updateScore(&player, &currentLevel);
    printf("Your score is %d\n", player.score);
    
    return 0;
}

// Generate a game board with random numbers
void generateBoard(GameLevel *level) {
    int i, j;

    level->numRows = 8;
    level->numCols = 8;
 
    for (i = 0; i < level->numRows; i++) {
        for (j = 0; j < level->numCols; j++) {
            // Randomly generate a number from 0 to 9
            level->board[i][j] = (rand() % 10) + '0';
        }
    }
}

// Print out the game board
void printBoard(GameLevel *level) {
    int i, j;

    for (i = 0; i < level->numRows; i++) {
        for (j = 0; j < level->numCols; j++) {
            printf("%c ", level->board[i][j]);
        }
        printf("\n");
    }
}

// Update the score of the player
void updateScore(Player *player, GameLevel *level) {
    int i, j;

    for (i = 0; i < level->numRows; i++) {
        for (j = 0; j < level->numCols; j++) {
            if (level->board[i][j] > '0' && level->board[i][j] <= '9') {
                // Increment the score
                player->score += level->board[i][j] - '0';
            }
        }
    }
}