/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Secret Agency
FECHA:      14 de marzo del 2023
*/

#include "list.hpp"

List::Node::Node(Record r)
{
    next = nullptr;
    datum = r;
}

List::List(int _n)
{
    n = _n;
    s = 0;
    start = nullptr;
}

List::~List()
{
    Node *p = start;

    while (p != nullptr)
    {
        Node *next = p->getNext();
        delete p;
        p = next;
    }

    start = nullptr;
}

bool List::insert(Record datum)
{
    assert(!(isFull()));

    if (isEmpty())
    {
        Node *a = new Node(datum);
        start = a;
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
            if (q->getDatum().key == datum.key)
            {
                return false;
            }
            q->setNext(aux);
        }
        else if (p == start)
        { // Start Insertion
            if (p->getDatum().key == datum.key)
            {
                return false;
            }
            aux->setNext(start);
            start = aux;
        }
        else
        { // Between Insertion
            if (p->getDatum().key == datum.key)
            {
                return false;
            }
            aux->setNext(p);
            q->setNext(aux);
        }
    }

    s++;
    return true;
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
        s--;
        return true;
    }

    return false;
}

void List::print()
{

    for (Node *aux = start; aux; aux = aux->getNext())
    {
        cout
            << "\nKey Name   :  " << aux->getDatum().key
            << "\nReal Name  :  " << aux->getDatum().name
            << "\nAge        :  " << aux->getDatum().age
            << "\nCountry    :  " << aux->getDatum().country << "\n";
    }
}