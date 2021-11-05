CC = g++
CFLAGS = -Wall -pedantic-errors -g

all:
	$(CC) $(CFLAGS)  -c Matrix.h Matrix.cpp
	$(CC) $(CFLAGS) -o p1 p1.cpp Matrix.cpp

run: all
	./p1

clean:
	rm p1
