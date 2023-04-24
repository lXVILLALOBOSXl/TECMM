/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#ifndef tree_hpp
#define tree_hpp

#include <iostream>
#include <assert.h>

using namespace std;

class Tree
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

    void inorder(Node *);

public:

    Tree(int);
    ~Tree();

    void insert(int);
    void print();

    int getSize() const { return s; }
    int getCapacity() const { return n; }

    bool isFull() { return n == s; }
    bool isEmpty() { return s == 0; }
};

#endif