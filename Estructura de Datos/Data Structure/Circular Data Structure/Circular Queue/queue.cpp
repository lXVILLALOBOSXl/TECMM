/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Circular Queue
FECHA:      20 de febrero del 2023
*/

#include "queue.hpp"

Queue::Queue(int capacity){

    this -> s  = 0;
    this -> c = capacity;
    this -> _rear = 0;
    this -> _front = 0;

    this -> list = new int[capacity];
}

Queue::~Queue() {

    delete [] list;
}

void Queue::enqueue(int x){

    assert(!(this -> isFull()));

    this -> list[this -> _rear] = x;
    this -> _rear = this -> forth(this -> _rear, this -> c);

    this -> s++;
}

void Queue::dequeue(){

    assert(!(this -> isEmpty()));

    this -> _front = this -> forth(this -> _front, this -> c);
    this -> s--;
    
}

int Queue::front(){

    assert(!(this -> isEmpty()));

    return this -> list[this->_front];
}

void Queue::print(){

    printf("[");
    
    if(!this -> isEmpty()){
        int i = this -> _front;
        do 
        {
            printf(" %i", this -> list[i]);
            i = this -> forth(i, this -> c);
        }while (i != this -> _rear);
    }
    
    printf(" ]\n");
    
}