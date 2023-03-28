/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Search
FECHA:      28 de marzo del 2023
*/

#include <iostream>
#include <time.h>

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

    printf("[ ");
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

int counter;

/*Function isearch(A: a1,a2 … an, x E 0): {false, true}

Lower <- 1
Higher <- n
While lower < higher and a[lower] <= x and x<= a[higher]
	Center <- lower + ((x - a[lower])(higher - lower)) / (a[higher] - a[lower])
	If a[center] < x then lower <- center + 1
	Else if x < a[center] then higher <- center - 1
	Else return true
Return false

*/

// A is an ordered array
int search(int x, int *a, int n)
{
    int left = 0;
    int right =  n - 1;

    while (left < right and a[left] <= x and x <= a[right])
    {
        counter++;

        int middle = left + ( ((x - a[left])*(right - left)) / (a[right] - a[left]) );

        if(a[middle] < x){
            left = middle + 1;
        }else if(x < a[middle]){
            right = middle - 1;
        }else{
            return middle;
        }
    }

    return -1;
    
}

int main(int argc, char const *argv[])
{

    srand((unsigned(time(nullptr))));

    /*int n = 20;
    int *a = create(n);
    bubbleSort(a,n);
    int x = rand() % (10 * n) + 1;

    print(a,n);
    printf("%i: ", x);

    int index = search(x,a,n);
    if(index > -1){
        printf("There is %i\n", index);
    }else{
        printf("There isn't\n");
    }*/

    for (int n = 100; n <= 1000; n += 100)
    {
        int ok = 0;  // Positive cases
        int nok = 0; // Negative cases

        int sfok = 0;  // Steps counter positive cases
        int sfnok = 0; // Steps counter negative cases

        for (int i = 0; i < 1000; i++)
        {

            int *a = create(n);
            bubbleSort(a,n);
            int x = rand() % (10 * n) + 1;

            counter = 0;

            if (search(x, a, n) < 0)
            {
                nok++;
                sfnok += counter;
            }
            else
            {
                ok++;
                sfok += counter;
            }

            delete[] a;
        }

        // Size, ok cases, ok promedy, nok cases, nok promedy
        printf("%i %i %.2f %i %.2f\n",n , ok, (float)sfok / ok, nok, (float)sfnok / nok);
    }



    return 0;
}