/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Secret Agency
FECHA:      14 de marzo del 2023
*/

#ifndef list_hpp
#define list_hpp

#include <assert.h>
#include <string>
#include <iostream>

using namespace std;

typedef struct
{
    string key;
    string name;
    int age;
    string country;

} Record;

class List
{

    class Node
    {

        Record datum;
        Node *next;

    public:
        Node(Record datum);

        Record getDatum() const { return datum; } // const says that function doesn´t modify the object
        Node *getNext() const { return next; }
        Node *setNext(Node *p) { return next = p; }
    };

    Node *start;

    int s; // size
    int n; // capacity

public:
    List(int);
    ~List();

    bool insert(Record);
    bool find(string, Record &); // says if the item is there and change the value to item founded
    bool _delete(string);

    int size() const { return this->s; }
    int capacity() const { return this->n; }

    bool isEmpty() const { return this->s == 0; };
    bool isFull() const { return this->s == this->n; };

    void print();
};

#endif