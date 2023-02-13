/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Arrays and pointers
FECHA:      7 de febrero del 2023
*/

#include <iostream>

void print(int *a, int n){
    for (int i = 0; i < n; i++)
    {
        //printf("%i ", a[i]);
        //printf("%i ", *(a + i));
        // printf("%i ", *a);
        // a++;
        printf("%i ", *a++);

    }

}

int main(int argc, char const *argv[]){
    
    int a[10] = {6, 3, 10, -4, 5, 12, -2, 0, 1, 19};


    print(a, 10);
    printf("\n\n");
    printf("&a[0]:  %p\n ", &a[0]);
    printf("a:      %p\n ", a);
    printf("*a:     %i\n ", *a);


    return 0;
}