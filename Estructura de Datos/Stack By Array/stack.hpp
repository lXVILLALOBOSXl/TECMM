/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Stack By Array
FECHA:      14 de febrero del 2023
*/

#ifndef stack_hpp
#define stack_hpp

#include <stdio.h>

class Stack{

    int *list; // array
    int s;     // size
    int n;     // capacity

public:

    Stack(int capacity);
    ~Stack();

    void push(int);
    void pop();
    int top();

    int size();
    int capacity();
    
    bool empty();
    bool full();

};

#endif