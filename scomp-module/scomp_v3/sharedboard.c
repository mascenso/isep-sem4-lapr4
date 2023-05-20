#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <time.h>
#include <signal.h>
#include <string.h>
#include <fcntl.h> 
#include <sys/types.h> 
#include <sys/stat.h> 
#include <sys/mman.h> 
#include <sys/wait.h>
#include <semaphore.h>
#include "sharedboard.h"

#define CHILDS 30 // nº de pessoas a aceder ao mesmo tempo ao conteudo da board


int main(){

    int fd = shm_open(SHM_NAME,O_CREAT|O_EXCL|O_RDWR,S_IRUSR|S_IWUSR); //cria se ainda nao existir, com permissoes de escrita e leitura
    if(fd == -1) {
        perror("Failed shm_open!!!");
		exit(EXIT_FAILURE);
	}

    if(ftruncate(fd, DATA_SIZE) == -1) {
		fprintf(stderr, "ftruncate() failed for %s!!!\n%s\n", SHM_NAME, strerror(errno));
		exit(EXIT_FAILURE);
	}
    
    sharedBoard* board = (sharedBoard*) mmap(NULL,DATA_SIZE,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0); //mapeia a memoria partilhada ao espaço de endereçamento do processo
    if(board == MAP_FAILED) {
		fprintf(stderr, "mmap() failed for %s!!!\n%s\n", SHM_NAME, strerror(errno));
		exit(EXIT_FAILURE);
	}

	char sems_names[QTD_SEMS][NAME_SIZE]; /* Nomes para os semáforos, um nome em cada linha da matriz de chars */
	memset(sems_names, 0, sizeof(sems_names)); /* Inicializar a zero toda a matriz de chars */
    int i, j; 

    //semaforos
	sem_t* sems[QTD_SEMS];
	memset(sems, 0, sizeof(sems)); /* Inicializar a zero todo o vetor */
	for(i=0; i<QTD_SEMS; ++i) { // Vai inicializar todos os semaforos a 1
		snprintf(sems_names[i], NAME_SIZE, "%s%d", SEMS_NAME_BASE, i); /* Gera dinamicamente o nome para o semáforo */ 
		if ((sems[i] = sem_open(sems_names[i], O_CREAT | O_EXCL, 0644, 1)) == SEM_FAILED ) { /* Criar os semáforos */
			fprintf(stderr, "sem_open() failed for %s!!!\n%s\n", sems_names[i], strerror(errno));
			exit(EXIT_FAILURE);
		}
	}

    pid_t pid[CHILDS];

    for(j=0;j<CHILDS;j++){
        pid[j]=fork();

        if (pid[j] ==-1){
            perror("Fork failed!");
            exit(EXIT_FAILURE);
        }

        if(pid[j]==0){//filho -> pessoas a acederem

            srand((unsigned) (time(NULL) ^ getpid()));
            int post_it_index =rand()%NUM_POST_ITS;

            // Aguarda o semáforo específico do post-it para escrever
            sem_wait(sems[post_it_index]);
        
            // Escreve o post-it
            board->post_its[post_it_index]++;
            printf("Processo %d escreveu no post-it %d.\n", j, post_it_index+1);

            // Libera o semáforo após escrever
            sem_post(sems[post_it_index]);
        
            exit(EXIT_SUCCESS);
        }
    }
    
    // Espera todos os processos filhos terminarem
    int status;
    for (i = 0; i < CHILDS; i++) {
        waitpid(pid[i], &status, 0);
    }
    int sum=0;
    // Processo pai
    printf("\nConteúdo dos post-its:\n");
    for (i = 0; i < NUM_POST_ITS; i++) {
        sum=sum+board->post_its[i];
        printf("Post-it %d: %d\n", i+1, board->post_its[i]);
    }
    printf("Numero de acesso= %d\n",sum);

      /* Fechar os semaforos */
    for (i = 0; i < QTD_SEMS; i++) {
        if (sem_close(sems[i]) < 0) {
            fprintf(stderr, "sem_close() failed on %s\n%s\n", sems_names[i], strerror(errno));
            exit(EXIT_FAILURE);
        }
    }

    //FECHA E APAGA A MP
    if (munmap(board, DATA_SIZE) == -1) {
		fprintf(stderr, "munmap() failed!!!\n%s\n", strerror(errno));
		exit(EXIT_FAILURE);
	}

    //FECHA A MP
	if(close(fd) == -1) {
		fprintf(stderr, "close() failed!!!\n%s\n", strerror(errno));
		exit(EXIT_FAILURE);
	}

    //REMOVE DA ZONA DE MEMORIA
    if(shm_unlink(SHM_NAME) == -1) {
		fprintf(stderr, "shm_unlink() failed for %s!!!\n%s\n", SHM_NAME, strerror(errno));
		exit(EXIT_FAILURE);
    }

    return 0;
}