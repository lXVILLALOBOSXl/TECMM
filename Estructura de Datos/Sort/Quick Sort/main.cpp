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
/*
Procedure qsort(A: a1a2…an-1,left,right)
	I, j: indice
	Pivot: O
	
Pivot <- a[(left + right)/2]
I <- left
J <- right
Do
	While ai < pivot do inc(i)
	While pivot < aj do dec(j)
	If i <= j then
		Swap(ai, aj)
		Inc(i)
		Dec(j)
	End if
While i <= j
If left < j then qsort(a1a2…an-1,left,j)
If i < right then qsort(a1a2…an-1, i,right)
*/
void quickSort(int *a, int left, int right){
    int i = left;
    int j = right;
    int pivot = a[(left + right) / 2];

    do
    {
        while (a[i] < pivot)
        {
            i++;
        }

        while (pivot < a[j])
        {
            j--;
        }

        if(i <= j){
            swap(a[i], a[j]);
            i++;
            j--;
        }

    } while (i <= j);
    
    if(left < j){
        quickSort(a, left, j);
    }

    if(i < right){
        quickSort(a, i, right);
    }
    
}

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    int n = 10;
    int  *a = create(n);
    print(a,n);

    quickSort(a,0,(n-1));
    print(a,n);


    delete [] a;
    return 0;
}