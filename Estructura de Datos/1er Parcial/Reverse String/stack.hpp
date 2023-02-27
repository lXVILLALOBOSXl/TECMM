/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Reverse String
FECHA:      29 de marzo del 2023
*/

#ifndef stack_hpp
#define stack_hpp

#include <assert.h>
#include <iostream>

class Stack{

    char *list; // array
    int s;     // size
    int n;     // capacity

public:

    Stack(int);
    ~Stack();

    void push(char);
    void pop();
    int top();

    int size() const { return this -> s; }
    int capacity() const { return this -> n; }
    
    bool isEmpty() const { return this -> s == 0; };
    bool isFull() const { return this -> s == this -> n; };

    void print();

};

#endif