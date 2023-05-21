#ifndef SHAREDBOARD_H
#define SHAREDBOARD_H

#define SHM_NAME "/bwwsbd"
#define SEMS_NAME_BASE "/swwdsd"
#define NAME_SIZE 20 
#define NUM_POST_ITS 20

typedef struct{
    int post_its[NUM_POST_ITS];
}sharedBoard;

int DATA_SIZE=sizeof(sharedBoard);
int QTD_SEMS=NUM_POST_ITS;

#endif