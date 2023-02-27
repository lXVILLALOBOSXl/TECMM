/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Ordered list
FECHA:      27 de febrero del 2023
*/

#include "list.hpp"

List::Node::Node(int x){
    this -> next = nullptr;
    this -> datum = x;
}

List::List(int n){
    this -> n = n;
    this -> s = 0;
    this -> start = nullptr;
}

List::~List(){

}

void List::insert(int x){
    assert(!(this -> isFull()));

    if(this -> isEmpty()){
        this -> start = new Node(x);
    }else{

        Node *p = start;
        Node *q;

        while (p != nullptr && p -> getDatum() < x)
        {
            q = p;
            p = p -> getNext();
        }

        Node *aux = new Node(x);

        //Final Insertion
        if(p == nullptr){

            q -> setNext(aux);

        }else if(p == this -> start){//Start Insertion

            aux -> setNext(this -> start);
            this -> start = aux;

        }else{ //Between Insertion

            aux -> setNext(p);
            q -> setNext(aux);

        }
        
    }

    this -> s++;

}

void List::print(){

    printf("[");
 
    for (Node *aux = start; aux; aux = aux -> getNext())
    {
        printf(" %i",aux -> getDatum());
    }

    printf(" ]\n");

}