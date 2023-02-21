/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Stack By Array
FECHA:      14 de febrero del 2023
*/

#include "stack.hpp"

Stack::Stack(int capacity){

    this -> s  = 0;
    this -> n = capacity;

    this -> list = new int[n];
}

Stack::~Stack() {

    delete [] list;
}

void Stack::push(int x){

    assert(!(this -> isFull()));

    this -> list[s++] = x;
}

void Stack::pop(){
    
    assert(!(this -> isEmpty()));

    this -> s--;
}

int Stack::top(){

    assert(!(this -> isEmpty()));

    return this -> list[s - 1];
    
}

void Stack::print(){

    printf("[");

    for (int i = 0; i < this -> s; i++)
    {
        printf(" %i", this -> list[i]);
    }
    
    printf(" ]\n");
    
}