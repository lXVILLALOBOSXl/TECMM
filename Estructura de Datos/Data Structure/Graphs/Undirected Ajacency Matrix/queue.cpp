/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Queue
FECHA:      21 de febrero del 2023
*/

#include "queue.hpp"

Queue::Node::Node(int x){
    this -> next = nullptr;
    this -> datum = x;

}

Queue::Queue(int capacity){

    this -> _front = nullptr;
    this -> _rear = nullptr;
    this -> s = 0;
    this -> n = capacity;

}

Queue::~Queue(){

    delete this -> _front;

    
}

void Queue::enqueue(int x){

    assert(!(this -> isFull()));

    s++;

    if((this -> _rear)){
        Node *aux = new Node(x);
        this -> _rear -> setNext(aux);
        this -> _rear = aux;
        return;
    }

    this -> _rear = new Node(x);
    this -> _front = this -> _rear;

}

int Queue::dequeue(){

    assert(!(this -> isEmpty()));
    int deleted;

    Node *aux = this -> _front;
    this -> _front = aux -> getNext();
    deleted = aux->getDatum();
    delete aux;

    if(!(this -> _front)){
        this->_rear = nullptr;
    }

    s--;
    return deleted;
}

int Queue::front(){

    assert(!(this -> isEmpty()));

    return this -> _front -> getDatum();

}

void Queue::print(){

    printf("[");
 
    for (Node *aux = this -> _front; aux; aux = aux -> getNext())
    {
        cout<<" "<<aux -> getDatum();
    }
    
    
    printf(" ]\n");
    
}