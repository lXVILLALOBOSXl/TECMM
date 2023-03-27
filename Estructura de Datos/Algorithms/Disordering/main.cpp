/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Disordering
FECHA:      27 de marzo del 2023
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

    printf("[ ");
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

void disord(int *a, int n){
    int k = n;
    while (k > 1)
    {
        swap(a[k],a[rand() % ((k - 1)  - (0 - 1)) + 0]);
        k--;
    }
    
}

void bubbleSort(int *a, int n){

    // Lim to make pairs
    for (int k = n - 1; k > 0; k--)
    {
        // Form pairs
        for (int i = 0; i < k; i++)
        {
            if(a[i] > a[i + 1]){
                swap(a[i],a[i + 1]);
            }
        }
        
    }
    
    
}

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));
    int n = 10;

    int  *a = create(n);
    print(a,n);
    bubbleSort(a,n);
    print(a,n);
    disord(a,n);
    print(a,n);


    delete [] a;
    return 0;
}