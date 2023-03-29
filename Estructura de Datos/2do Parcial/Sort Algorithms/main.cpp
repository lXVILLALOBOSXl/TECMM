/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Sort Algorithms
FECHA:      29 de marzo del 2023
*/

#include <iostream>
#include <time.h>
#include "sort.hpp"

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

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    int n = 10;
    int  *a = create(n);
    printf("\nArray: \n");
    print(a,n);

    printf("\nQsorted array: \n");
    Sort::quick(a,0,(n-1));
    print(a,n);

    int  *b = create(n);
    printf("\nArray: \n");
    print(b,n);

    printf("\nHeapsorted array: \n");  
    Sort::heap(b,n);
    print(b,n);

    int  *c = create(n);
    printf("\nArray: \n");
    print(c,n);

    printf("\nMergesorted array: \n");  
    Sort::merge(c,0,n-1);
    print(c,n);


    delete [] a;
    delete [] b;
    delete [] c;

    return 0;
}