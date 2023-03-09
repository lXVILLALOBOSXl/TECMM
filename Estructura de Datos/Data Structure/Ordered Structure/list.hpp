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

    Node * find(int x){ //pass the item if it was found

        Node *p = start;

        while (p != nullptr and p->getDatum() < x)
        {
            p = p->getNext();
        }

        if (p != nullptr and p->getDatum() == x)
        {
            return p;
        }
        
        return nullptr;

    } 

    /*
        function search(list: pointer to node, x: data): pointer to node
        precondition: The list is sorted

        p <- list
        while p != null and p^.data < x do
            p <- p^.next
        end while
        if p != NULL and p^.data = x then return p
        else return null
    */
public:

    List(int);
    ~List();

    void insert(int);
    // bool find(int); only says if the item is there
    // int find(int); //copy the value if the item was found
    bool find(int, Node &); // says if the item is there and change the value to item founded
    bool _delete(int);

    int size() const { return this -> s; }
    int capacity() const { return this -> n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> n; };

    void print();

};

#endif