/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Max Heap
FECHA:      13 de Marzo del 2023
*/

#include <iostream>
#include <time.h>
#include "heap.hpp"

using namespace std;

int main(int argc, char const *argv[])
{

    srand((unsigned) time(nullptr));

    int n = 1;
    Heap h(n);

    for (int i = 0; i < n; i++)
    {
        int x = rand() % 10 * n + 1;
        cout<< "ins " << x << " ";
        h.insert(x);
        h.print();
    }

    cout<<"-------------------------"<<endl;

    while (!h.isEmpty())
    {
        cout <<"rem "<< h.takeOut() << " ";
        h.print();
    }
    
    

    return 0;
}