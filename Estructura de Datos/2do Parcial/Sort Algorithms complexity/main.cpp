/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Sort Algorithms
FECHA:      29 de marzo del 2023
*/

#include <iostream>
#include <time.h>
#include <string>
#include <iostream>
#include "sort.hpp"

int *create(int n)
{

    int *p = new int[n];
    for (int i = 0; i < n; i++)
    {
        p[i] = rand() % (10 * n) + 1;
    }
    return p;
}

void print(int *a, int n)
{

    printf("[");
    for (int i = 0; i < n; i++)
    {
        printf("%i ", a[i]);
    }
    printf("]\n");
}

int main(int argc, char const *argv[])
{

    srand((unsigned(time(nullptr))));

    char option;

    scanf("%c", &option);

    switch (option)
    {
    case 'Q':
        printf("Quicksort\n");
        break;
    case 'M':
        printf("Mergesort\n");
        break;
    case 'H':
        printf("Heapsort\n");
        break;
    default:
        return 0;
    }

    for (int n = 100; n <= 1000; n += 100)
    {
        int effort = 0;

        for (int i = 0; i < 1000; i++)
        {
            int *a = create(n);

            counter = 0;

            switch (option)
            {
            case 'Q':
                Sort::quick(a, 0, (n - 1));
                break;
            case 'M':
                Sort::merge(a, 0, n - 1);
                break;
            case 'H':
                Sort::heap(a, n);
                break;
            }

            effort += counter;

            delete[] a;
        }
        

        printf("%i      %.1f\n", n, (float)(effort/1000));
        
    }

    return 0;
}