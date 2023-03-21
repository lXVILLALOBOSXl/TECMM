/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Heaping An Array
FECHA:      14 de marzo del 2023
*/

#include <iostream>

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

void swap(int &a, int &b)
{
    int aux = a;
    a = b;
    b = aux;
}

void bubbleSort(int *a, int n)
{

    // Lim to make pairs
    for (int k = n - 1; k > 0; k--)
    {
        // Form pairs
        for (int i = 0; i < k; i++)
        {
            if (a[i] > a[i + 1])
            {
                swap(a[i], a[i + 1]);
            }
        }
    }
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

int main(int argc, char const *argv[])
{

    srand((unsigned(time(nullptr))));

    int n = rand() % 11 + 10;
    int m = rand() % 11 + 10;

    int *L1 = create(n);
    int *L2 = create(m);

    print(L1, n);
    print(L2, n);


    bubbleSort(L1, n);
    bubbleSort(L2, m);

    printf("List 1 (%i):\n", n);
    print(L1, n);

    printf("List 2 (%i):\n", m);
    print(L2, m);

    int *L = merge(L1, n, L2, m);

    printf("\nMix (%i):\n", n + m);
    print(L, n + m);

    delete[] L1;
    delete[] L2;
    delete[] L;

    return 0;
}