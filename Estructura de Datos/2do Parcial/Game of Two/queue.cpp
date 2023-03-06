/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Game of Two
FECHA:      10 de marzo del 2023
*/

#include "queue.hpp"

Queue::Queue(int capacity)
{

    s = 0;
    c = capacity;
    _rear = 0;
    _front = 0;

    list = new int[capacity];
}

Queue::~Queue()
{

    delete[] list;
}

void Queue::enqueue(int x)
{

    assert(!(isFull()));

    list[_rear] = x;
    _rear = forth(_rear, c);

    s++;
}

void Queue::dequeue()
{

    assert(!(isEmpty()));

    _front = forth(_front, c);
    s--;
}

int Queue::front()
{

    assert(!(isEmpty()));

    return list[_front];
}

int Queue::count()
{
    int count = 0;

    if (!isEmpty())
    {
        int i = _front;
        do
        {
            count += list[i];
            i = forth(i, c);
        } while (i != _rear);
    }
    
    return count;
}

void Queue::print()
{

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