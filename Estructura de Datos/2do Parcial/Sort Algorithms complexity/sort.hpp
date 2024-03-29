/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Sort Algorithms
FECHA:      29 de marzo del 2023
*/

#ifndef sort_hpp
#define sort_hpp

#include "heap.hpp"

float counter = 0;

class Sort
{
private:
    static void swap(int &a, int &b)
    {
        int aux = a;
        a = b;
        b = aux;
    }

    static int *merging(int *L1, int n, int *L2, int m)
    {

        int *L = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n and j < m)
        {
            L[k++] = (L1[i] < L2[j]) ? L1[i++] : L2[j++];
            counter++;
        }

        while (i < n)
        {
            L[k++] = L1[i++];
            counter++;
        }

        while (j < m)
        {
            L[k++] = L2[j++];
            counter++;
        }

        return L;
    }

public:
    Sort(){};
    ~Sort(){};

    static void quick(int *a, int left, int right)
    {
        int i = left;
        int j = right;
        int pivot = a[(left + right) / 2];


        do
        {
            while (a[i] < pivot)
            {
                counter++;
                i++;
            }

            while (pivot < a[j])
            {
                counter++;
                j--;
            }

            if (i <= j)
            {
                counter++;
                Sort::swap(a[i], a[j]);
                i++;
                j--;
            }

        } while (i <= j);


        if (left < j)
        {
            Sort::quick(a, left, j);
        }

        if (i < right)
        {
            Sort::quick(a, i, right);
        }
    }

    static void merge(int *a, int left, int right)
    {
        if (left < right)
        {

            int middle = (left + right) / 2;

            merge(a, left, middle);
            merge(a, middle + 1, right);

            int *mergeArray = merging(&a[left], middle - left + 1, &a[middle + 1], right - middle);

            for (int i = 0; i < right - left + 1; i++)
            {
                a[left + i] = mergeArray[i];
            }

            counter++;

            delete[] mergeArray;
        }
    }

    static void heap(int *a, int s)
    {
        Heap aux(s);
        for (int i = 0; i < s; i++)
        {
            counter++;
            aux.insert(a[i],counter);
        }

        int m = (s - 1);
        int x;

        do
        {
            x = aux.takeOut(counter);
            a[m--] = x;
            counter++;
        } while (m >= 0);
    }
};

#endif