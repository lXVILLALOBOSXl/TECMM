/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Sorting
FECHA:      6 de marzo del 2023
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

void swap(int &a, int &b){
    int aux = a;
    a = b;
    b = aux;
}

void selectionSort(int *a, int n){

    int k = n - 1;
    int i;

    while (k > 0)
    {
        int b = 0;

        for (i = 1; i <= k; i++)
        {
            b = (a[i] > a[b]) ? i : b;
        }
        printf("\nInterchange %i <-> %i\n", b, i - 1);
        swap(a[b], a[k]);
        print(a,n);
        
        k--;
    }
    
}

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    int n = 100;
    int  *a = create(n);
    print(a,n);

    selectionSort(a,n);
    print(a,n);


    delete [] a;
    return 0;
}