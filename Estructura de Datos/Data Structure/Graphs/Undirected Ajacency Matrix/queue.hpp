/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Queue
FECHA:      21 de febrero del 2023
*/

#ifndef queue_hpp
#define queue_hpp

#include <assert.h>
#include <iostream>

using namespace std;

class Queue{

    class Node {

        int datum;
        Node *next;

    public:

        Node(int);

        int getDatum() const { return datum; } //const says that function doesn´t modify the object
        Node *getNext() const { return next; }
        Node *setNext(Node *p) { return next = p; }

    };

    Node *_rear; //Dequeue
    Node *_front; //Enqueue

    int s;     // size
    int n;     // capacity

public:

    Queue(int);
    ~Queue();

    void enqueue(int);
    int dequeue();
    int front();

    int size() const { return this -> s; }
    int capacity() const { return this -> n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> n; };

    void print();

};

#endif