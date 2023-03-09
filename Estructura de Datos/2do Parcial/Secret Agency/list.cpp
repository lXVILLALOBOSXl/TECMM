/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Secret Agency
FECHA:      14 de marzo del 2023
*/

#include "list.hpp"

List::Node::Node(Record datum)
{
    next = nullptr;
    datum = datum;
}

List::List(int n)
{
    n = n;
    s = 0;
    start = nullptr;
}

List::~List()
{
    Node *p = start;
    Node *aux;

    while (start != nullptr)
    {
        aux = p;
        p = p->getNext();
        delete aux;
    }

    delete p;
}

bool List::insert(Record datum)
{
    assert(!(isFull()));

    if (isEmpty())
    {
        start = new Node(datum);
    }
    else
    {

        Node *p = start;
        Node *q;

        while (p != nullptr && p->getDatum().key < datum.key)
        {
            q = p;
            p = p->getNext();
        }

        Node *aux = new Node(datum);

        // Final Insertion
        if (p == nullptr)
        {

            q->setNext(aux);
        }
        else if (p == start)
        { // Start Insertion

            aux->setNext(start);
            start = aux;
        }
        else
        { // Between Insertion

            aux->setNext(p);
            q->setNext(aux);
        }
    }

    return true;
    s++;
}

bool List::find(string key, Record &datum)
{ // says if the item is there and change the value to item founded

    Node *p = start;

    while (p != nullptr and p->getDatum().key < key)
    {
        p = p->getNext();
    }

    if (p != nullptr and p->getDatum().key == key)
    {
        datum = p->getDatum();
        return true;
    }

    return false;
}

bool List::_delete(string key)
{

    Node *p;
    Node *q;
    p = start;

    while (p != nullptr and p->getDatum().key < key)
    {
        q = p;
        p = p->getNext();
    }

    if (p != nullptr and p->getDatum().key == key)
    {
        if (p == start)
        {
            start = p->getNext();
        }
        else
        {
            q->setNext(p->getNext());
        }

        delete p;
        return true;
    }

    return false;
}

void List::print()
{

    for (Node *aux = start; aux; aux = aux->getNext())
    {
        cout << "\nKey Name :" << aux->getDatum().key
         << "\nReal Name  :  " << aux->getDatum().name
         << "\nAge        :  " << aux->getDatum().age
         << "\nCountry    :  " << aux->getDatum().country<<"\n";
    }

}