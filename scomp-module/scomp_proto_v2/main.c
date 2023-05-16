#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <semaphore.h>
#include <errno.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <time.h>
#include "sharedboard.h"

#define SEMS_NAME_BASE "/sem_sem4pi_"
#define SHM_NAME "/shm_sem4pi"
#define MAX_TAM_STR 25
#define QTD_FILHOS 10

int cria_filhos(int n);

int main() {

    /* Shared memory --------------------------------------------------------------------------*/
    KanbanBoard *board; /* Apontador para a zona de memória partilhada */

    const int DATA_SIZE = sizeof(KanbanBoard); /* Tamanho da zona de memória partilhada */

    int fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, S_IRUSR | S_IWUSR);
    if (fd == -1) {
        perror("shm_open");
        exit(1);
    }

    // Set size of shared memory object
    if (ftruncate(fd, DATA_SIZE) == -1) {
        perror("ftruncate");
        exit(1);
    }

    // Map shared memory object into process address space
    board = mmap(NULL, DATA_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    if (board == MAP_FAILED) {
        perror("mmap");
        exit(1);
    }

    /*-------------------------------------------------------------------------------------*/
    // Initialize shared memory

    board->numColumns = 0;

    // Add some initial columns
    addColumn(board, "To Do");
    addColumn(board, "In Progress");
    addColumn(board, "Done");

    // Add cards to the first column
    addCard(board, 0, "Task 1");
    addCard(board, 0, "Task 2");
    addCard(board, 0, "Task 3");

    // Add cards to the second column
    addCard(board, 1, "Task 4");


    /*-------------------------------------------------------------------------------------*/

    int i = 0;

    enum index {
        EXCLUSAO_COL
    }; /* Enumerado para facilitar a leitura do código de utilização dos semáforos */

    int sems_init_values[] = {1}; /* Valor inicial para cada um dos semáforos */

    const int QTD_SEMS = sizeof(sems_init_values) / sizeof(sems_init_values[0]); /* Quantidade de semáforos */
    char sems_names[QTD_SEMS][MAX_TAM_STR]; /* Nomes para os semáforos, um nome em cada linha da matriz de chars */
    memset(sems_names, 0, sizeof(sems_names)); /* Inicializar a zero toda a matriz de chars */


    /***** SEMAFOROS *****/
    sem_t *sems[QTD_SEMS];
    memset(sems, 0, sizeof(sems)); /* Inicializar a zero o vetor */
    for (i = 0; i < QTD_SEMS; ++i) {
        snprintf(sems_names[i], MAX_TAM_STR, "%s%d", SEMS_NAME_BASE, i); /* Gera dinamicamente o nome para o semáforo */
        if ((sems[i] = sem_open(sems_names[i], O_CREAT | O_EXCL, 0644, sems_init_values[i])) ==
            SEM_FAILED) { /* Criar os semáforos */
            fprintf(stderr, "sem_open() failed for %s!!!\n%s\n", sems_names[i], strerror(errno));
            exit(EXIT_FAILURE);
        }
    }



    /***** PROCESSOS *****/
    int id = cria_filhos(QTD_FILHOS);

    if (id == -1) {
        perror("fork() failed!!! ");
        exit(EXIT_FAILURE);
    }


    if (id == 0) { /***** Código do processo pai *****/

        /* Esperar que os filhos terminem (neste caso é apenas um filho, mas facilita a reutilização para exs com mais filhos) */
        int status = 0;
        for (i = 0; i < QTD_FILHOS; ++i) {
            if (wait(&status) == -1) {
                perror("wait() failed!");
                exit(EXIT_FAILURE);
            }
        }
        if (!WIFEXITED(status) || WEXITSTATUS(status) != EXIT_SUCCESS) {
            perror("Filho terminou com erro! ");
            exit(EXIT_FAILURE);
        }

        // Display the board
        displayBoard(board);


    } else { /***** Código dos processos que movem cartao *****/

        srand(time(NULL) ^ (getpid() << 16)); //gera uma seed diferente para cada processo filho
        int dest = rand() % 3; //
        sleep(1);
        srand(time(NULL) ^ (getpid() << 16));
        int source = rand()%3;

        sem_wait(sems[EXCLUSAO_COL]);
        // Move a card from the first column to the third column
        moveCard(board, source, dest, 0);
        sem_post(sems[EXCLUSAO_COL]);

        }




    /* Fechar os semaforos */
    for (i = 0; i < QTD_SEMS; i++) {
        if (sem_close(sems[i]) < 0) {
            fprintf(stderr, "sem_close() failed on %s\n%s\n", sems_names[i], strerror(errno));
            exit(EXIT_FAILURE);
        }
    }

    /* Fechar a memória partilhada */
    if (munmap(board, DATA_SIZE) == -1) {
        perror("failed munmap! ");
        exit(EXIT_FAILURE);
    }
    if (close(fd) == -1) {
        perror("failed munmap! ");
        exit(EXIT_FAILURE);
    }


    /***** Código apenas para o pai *****/
    if (id == 0) {
        /* Remover a memória partilhada */
        if (shm_unlink(SHM_NAME) == -1) {
            perror("failed shm_unlink! ");
            exit(EXIT_FAILURE);
        }

        /* Remover os semaforos */
        for (i = 0; i < QTD_SEMS; ++i) {
            if (sem_unlink(sems_names[i]) < 0) {
                fprintf(stderr, "sem_unlink() failed on %s\n%s\n", sems_names[i], strerror(errno));
                exit(EXIT_FAILURE);
            }
        }
    }

    return 0;
}

/**
 * devolve 0 no processo pai, devolve >0 nos processos filho
 */
int cria_filhos(int n) {
    pid_t pid;

    int i = 0;
    for (i = 0; i < n; ++i) {
        pid = fork();
        if (pid < 0)
            return -1;
        else if (pid == 0)
            return i + 1;
    }
    return 0;
}

