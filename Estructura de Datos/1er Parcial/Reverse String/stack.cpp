/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Reverse String
FECHA:      29 de marzo del 2023
*/

#include "stack.hpp"

Stack::Stack(int capacity){

    this -> s  = 0;
    this -> n = capacity;

    this -> list = new char[n];
}

Stack::~Stack() {

    delete [] list;
}

void Stack::push(char c){

    assert(!(this -> isFull()));

    this -> list[s++] = c;
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