/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Heaping An Array
FECHA:      14 de marzo del 2023
*/

#include <iostream>
#include <iomanip>
#include <time.h>
#include "heap.hpp"

int *create(int n){

    int *p = new int[n];
    for (int i = 0; i < n; i++)
    {
        p[i] = rand() % (10 * n) + 1;
    }
    return p;
    
}

void print(int *a, int n){

    printf("[");
    for (int i = 0; i < n; i++)
    {
        printf("%i ", a[i]);
    }
    printf("]\n");
    
}

void swap(int &a, int &b){
    int aux = a;
    a = b;
    b = aux;
}


int main(int argc, char const *argv[]){

    srand((unsigned) time(nullptr));

    int n = 10;
    Heap h(n);

    for (int i = 0; i < n; i++)
    {
        int x = rand() % 10 * n + 1;
        cout <<"ins: "<< setw(3) <<x << "   ";
        h.insert(x);
        h.print();
    }

    cout<<endl;
    int size = h.size();
    int * sortedArray = h.heapSort();
    print(sortedArray, size);

    return 0;
}