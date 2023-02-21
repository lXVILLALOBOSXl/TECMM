/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Queue By Array
FECHA:      21 de febrero del 2023
*/

#ifndef queue_hpp
#define queue_hpp

#include <assert.h>
#include <iostream>

class Queue{

    int *list; // array
    int s;     // size
    int c;     // capacity

public:

    Queue(int);
    ~Queue();

    void enqueue(int); //Insertion
    void dequeue(); //Delete
    int front(); //read

    int size() const { return this -> s; }
    int capacity() const { return this -> c; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> c; };

    void print();

};

#endif