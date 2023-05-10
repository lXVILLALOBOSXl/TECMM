/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#ifndef stack_hpp
#define stack_hpp

#include <assert.h>
#include <iostream>

using namespace std;

class Stack{

    class Node {

        int datum;
        Node *next;

    public:

        Node(int);

        int getDatum() const { return datum; } //const says that function doesn´t modify the object
        Node *getNext() const { return next; }
        Node *setNext(Node *p) { return next = p; }


    };

    Node *head; 

    int s;     // size
    int n;     // capacity

public:

    Stack(int);
    ~Stack();

    void push(int);
    void pop();
    int top();

    int size() const { return this -> s; }
    int capacity() const { return this -> n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> n; };

    void print();

};

#endif