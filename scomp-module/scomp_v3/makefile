# A Makefile with variables and suffix rules

# variáveis

INCLUDES = sharedboard.h
SOURCES = sharedboard.c
OBJFILES = sharedboard.o
EXEC = sharedboard

# Suffix rules
.SUFFIXES: .c .o

# How to build an object .o from a code file .c ; $< -- file name
.c.o:
	gcc -D_DARWIN_C_SOURCE -Wall -g -c $<
	
${EXEC}: ${OBJFILES}
	gcc -Wall -g -o ${EXEC} ${OBJFILES} -pthread
	
${OBJFILES}: ${SOURCES} ${INCLUDES}

run: ${EXEC}
	./${EXEC}

clean:
	rm -f ${OBJFILES} ${EXEC}
