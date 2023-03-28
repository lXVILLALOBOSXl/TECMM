/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Pokemon's Tournament
FECHA:      31 de Marzo del 2023
*/

#include "heap.hpp"

Heap::Heap(int capacity)
{
    n = capacity;
    s = 0;
    list = new int[capacity];
}

Heap::~Heap()
{
    delete[] list;
}

void Heap::insert(int x)
{
    assert(!(isFull()));

    list[s++] = x;
    int i = (s - 1);

    while (i > 0 and list[i] < list[parent(i)])
    {
        swap(list[i], list[parent(i)]);
        i = parent(i);
    }
}


int Heap::takeOut()
{
    assert(!isEmpty());

    int x = list[0];

    if(s > 1){

        list[0] = list[s - 1];
        int i = 0;

        int m = minChild(i);

        while (i <= parent(s - 1) and list[i] > list[m])
        {
            swap(list[i], list[m]);
            i = m;
            m = minChild(i);
        }
        
    }

    s--;
    return x;

}

int Heap::minChild(int parentIndex)
{
    if (right(parentIndex) > s - 1)
    {
        return left(parentIndex);
    }

    return list[left(parentIndex)] < list[right(parentIndex)] ? left(parentIndex) : right(parentIndex);
}

void Heap::swap(int &a, int &b)
{
    int aux = a;
    a = b;
    b = aux;
}

void Heap::print()
{
    printf("[ ");
    for (int i = 0; i < s; i++)
    {
        printf("%i ", list[i]);
    }
    printf("]\n");
}
