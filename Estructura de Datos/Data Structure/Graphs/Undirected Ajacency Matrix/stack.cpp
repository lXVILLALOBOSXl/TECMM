/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#include "stack.hpp"

Stack::Node::Node(int x){
    this -> next = nullptr;
    this -> datum = x;
}

Stack::Stack(int capacity){

    this -> head = nullptr;
    this -> s = 0;
    this -> n = capacity;

}

Stack::~Stack(){
    delete head;
}

void Stack::push(int x){

    assert(!(this -> isFull()));
    Node *aux = new Node(x);
    aux -> setNext(head);
    head = aux;

    s++;

}

void Stack::pop(){

    assert(!(this -> isEmpty()));
    Node *aux = this -> head;
    this -> head = aux -> getNext();
    delete aux;

    s--;
}

int Stack::top(){

    assert(!(this -> isEmpty()));

    return head -> getDatum();

}

void Stack::print(){

    printf("[");
 
    for (Node *aux = head; aux; aux = aux -> getNext())
    {
        cout<<" "<<aux -> getDatum();
    }
    
    
    printf(" ]\n");
    
}