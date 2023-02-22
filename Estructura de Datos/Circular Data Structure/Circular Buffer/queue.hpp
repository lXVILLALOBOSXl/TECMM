/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Circular Buffer
FECHA:      20 de febrero del 2023
*/

#ifndef queue_hpp
#define queue_hpp

#include <assert.h>
#include <iostream>

using namespace std;

class Queue{

    int *list; // array
    int s;     // size
    int c;     // capacity
    int _rear;
    int _front;

public:

    Queue(int);
    ~Queue();

    void enqueue(int); //Insertion
    void dequeue(); //Delete
    int front(); //read

    int size() const { return this -> s; }
    int capacity() const { return this -> c; }
    int forth(int i, int n) { return (i + 1) % n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> c; };

    void print();

};

#endif