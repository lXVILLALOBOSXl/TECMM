/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Pokemon's Tournament
FECHA:      31 de Marzo del 2023
*/

#include <iostream>
#include <time.h>

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
    print(a,n);

    delete [] a;
    return 0;
}