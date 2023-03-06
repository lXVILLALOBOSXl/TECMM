/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Sorting
FECHA:      6 de marzo del 2023
*/

#include <iostream>
#include <time.h>

typedef struct {
    int *data;
    int n;
} array;

int *create(int n){

    int *p = new int[n];
    for (int i = 0; i < n; i++)
    {
        p[i] = rand() % (10 + n) + 1;
    }
    return p;
    
}

void create(array & a, int n){

    a.data = create(n);
    a.n = n;
}

void print(array &a){

    printf("[");
    for (int i = 0; i < a.n; i++)
    {
        printf("%i ", a.data[i]);
    }
    printf("]\n");
    
}

int bigger(array &a){
    int b = 0;
    for (int i = 1; i < a.n; i++)
    {
        b = (a.data[i] > a.data[b]) ? i : b;
    }
    return b;
}

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    int n = 10;
    array a;
    create(a, n);
    print(a);

    int b = bigger(a);
    printf("\nEl mayor dato es el [%i]: %i\n", b, a.data[b]);

    delete [] a.data;
    return 0;
}