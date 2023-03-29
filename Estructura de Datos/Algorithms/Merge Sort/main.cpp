/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   QuickSort
FECHA:      21 de marzo del 2023
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

int *merge(int *L1, int n, int *L2, int m)
{

    int *L = new int[n + m];

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < n and j < m)
    {
        L[k++] = (L1[i] < L2[j]) ? L1[i++] : L2[j++];
    }

    while (i < n)
    {
        L[k++] = L1[i++];
    }

    while (j < m)
    {
        L[k++] = L2[j++];
    }

    return L;
}

void mergeSort(int *a, int left, int right){

    if (left < right) {

        int middle = (left + right) / 2;

        mergeSort(a, left, middle);
        mergeSort(a, middle + 1, right);

        int *mergeArray = merge(&a[left], middle - left + 1, &a[middle + 1], right - middle);

        for (int i = 0; i < right - left + 1; i++) {
            a[left + i] = mergeArray[i];
        }
        
        delete[] mergeArray;
    }

}


int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    int n = 10;
    int  *a = create(n);
    print(a,n);

    mergeSort(a,0,n-1);
    print(a,n);


    delete [] a;
    return 0;
}