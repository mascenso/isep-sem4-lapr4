# exemplo de makefile 
# variaveis do make
INCLUDES = sharedboard.h
SOURCES = main.c sharedboard.c
OBJFILES = $(addsuffix .o, $(basename $(SOURCES)))
#OBJFILES = $(patsubst %.s,%.o,$(patsubst %.c,%.o,$(SOURCES)))
EXEC = ex12

# regras de sufixo
.SUFFIXES : .s .c .o

# como transformar um .c num .o ; $< -- nome do ficheiro
.c.o:
	gcc -Wall -g -c $<  

# como transformar um .s num .o ; $< -- nome do ficheiro
.s.o:
	gcc -Wall -g -c $<  

# o eclipse assume que o target por defeito chama-se "all"
all: ${EXEC}

${OBJFILES}: ${SOURCES} ${INCLUDES}

# para fazer o programa principal 
${EXEC}: ${OBJFILES}
	gcc -Wall -g -o ${EXEC} ${OBJFILES} -lpthread -lrt -lm

run:  ${EXEC}
	./${EXEC}

clean:
	rm -f output.txt ${OBJFILES} ${EXEC} *~ .*~

debug: ${EXEC}
	gdb -tui ${EXEC}

test: ${EXEC}
	valgrind  ./${EXEC}


