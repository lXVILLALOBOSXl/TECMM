/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Binary Trees
FECHA:      22 de mayo del 2023
*/

#ifndef set_hpp
#define set_hpp

#include <iostream>
#include <assert.h>

using namespace std;

class Set
{

    class Node
    {

        int datum;
        Node *left;
        Node *right;

    public:
        Node(int);

        int getDatum() const { return datum; }

        Node *getLeft() const { return left; }
        Node *getRight() const { return right; }

        void setLeft(Node *p) { left = p; }
        void setRight(Node *p) { right = p; }
    };

    Node *root;

    int s;
    int n;

    void inOrder(Node *);
    void deleteSet(Node *);
    void cleanSet(Node *);

public:
    Set(int);
    ~Set();

    void insert(int);
    bool member(int);
    bool remove(int);
    void clean();
    void print();

    int getSize() const { return s; }
    int getCapacity() const { return n; }

    bool isFull() { return n == s; }
    bool isEmpty() { return s == 0; }
};

#endif