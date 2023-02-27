/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Ordered list
FECHA:      27 de febrero del 2023
*/

#ifndef list_hpp
#define list_hpp

#include <assert.h>
#include <iostream>

class List{

    class Node {

        int datum;
        Node *next;

    public:

        Node(int);

        int getDatum() const { return datum; } //const says that function doesn´t modify the object
        Node *getNext() const { return next; }
        Node *setNext(Node *p) { return next = p; }


    };

    Node *start; 

    int s;     // size
    int n;     // capacity

public:

    List(int);
    ~List();

    void insert(int);

    int size() const { return this -> s; }
    int capacity() const { return this -> n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> n; };

    void print();

};

#endif