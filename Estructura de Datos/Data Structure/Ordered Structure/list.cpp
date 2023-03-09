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

/*bool List::find(int x){ only says if the item is there

    Node *p = start;

        while (p != nullptr and p->getDatum() < x)
        {
            p = p->getNext();
        }

        if (p != nullptr and p->getDatum() == x)
        {
            return true;
        }
        
        return false;

}*/ 

/*int List::find(int x){ //copy the value if the item was found

    Node *p = start;

        while (p != nullptr and p->getDatum() < x)
        {
            p = p->getNext();
        }

        if (p != nullptr and p->getDatum() == x)
        {
            return p->getDatum();
        }
        
        return -1;

}*/ 

bool List::find(int x, Node & node){ // says if the item is there and change the value to item founded

    Node *p = start;

        while (p != nullptr and p->getDatum() < x)
        {
            p = p->getNext();
        }

        if (p != nullptr and p->getDatum() == x)
        {
            node = Node(p->getDatum());
            return true;
        }
        
        return false;

} 

bool List::_delete(int x){

    Node *p;
    Node *q;
    p = start;

    while (p != nullptr and p->getDatum() < x)
    {
        q = p;
        p = p->getNext();
    }

    if (p != nullptr and p->getDatum() == x)
    {
        if(p == start){
            start = p->getNext();
        }else{
            q->setNext(p->getNext());
        }
        
        delete p;
        return true;
    }

    return false;
    
}

/*
    procedure supr(list: pointer to node, x: data)
    precondition: The list is sorted
    p,q: pointers

    p <- list
    while p != null and p^.data < x do
        q <- p
        p <- p^.next
    end while
    if p != NULL and p^.data = x then {x was located}
        if p = list then {deletion at the front}
            list <- p^.next
        else {deletion at the middle}
            q^.next <- p^.next
        end if
        delete p
    end if
*/

void List::print(){

    printf("[");
 
    for (Node *aux = start; aux; aux = aux -> getNext())
    {
        printf(" %i",aux -> getDatum());
    }

    printf(" ]\n");

}