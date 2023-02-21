/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Queue By Array
FECHA:      21 de febrero del 2023
*/

#include "queue.hpp"

Queue::Queue(int capacity){

    this -> s  = 0;
    this -> c = capacity;

    this -> list = new int[capacity];
}

Queue::~Queue() {

    delete [] list;
}

void Queue::enqueue(int x){

    assert(!(this -> isFull()));

    this -> list[s++] = x;
}

void Queue::dequeue(){

    assert(!(this -> isEmpty()));

    int i = 0;
    this -> s--;
    while (i < this -> s)
    {
        this -> list[i] = this -> list[i + 1];
        i++;
    }
    
}

int Queue::front(){

    assert(!(this -> isEmpty()));

    return this -> list[0];
}

void Queue::print(){

    printf("[");

    for (int i = 0; i < this -> s; i++)
    {
        printf(" %i", this -> list[i]);
    }
    
    printf(" ]\n");
    
}