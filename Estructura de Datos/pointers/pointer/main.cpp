/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Pointers
FECHA:      7 de febrero del 2023
*/

#include <iostream>

//Pass copying references
void swap(int *m, int *n){

    int aux = *m;
    *m = *n;
    *n = aux;

}

/*//Pass copying values
void swap(int m, int n){

    int aux = m;
    m = n;
    n = aux;

}*/

int main(int argc, char const *argv[])
{
    /*//Copying values trhought pointers
    int x = 5;
    int *q = &x;
    int z = *q;
    printf(" z: %i\n",z);*/
    
    /*int a = 10;
    int *p = &a;

    printf(" a: %i\n",a);
    printf("&a: %p\n",&a);
    printf(" p: %p\n",p);
    printf("*p: %i\n",*p);*/


    /*int a = 45;
    int b = 12;

    printf("a: %i\n", a);
    printf("b: %i\n", b);

    swap(&a,&b);

    printf("a: %i\n", a);
    printf("b: %i\n", b);*/

    /*int *p = nullptr;

    if(p) printf("%i\n",*p);
    else printf("Null Value");*/

    /*printf("%lu\n", sizeof(int));
    printf("%lu\n", sizeof(long));
    printf("%lu\n", sizeof(char));
    printf("%lu\n", sizeof(int *));*/

    int a = 21;
    int *p = &a;

    printf("Size of int: %lu\n", sizeof(int *));
    printf(" p: %p\n",p);
    printf(" p+1: %p\n",p+1);
    printf(" p+2: %p\n",p+2);
    printf(" p-2: %p\n",p-2);

    p++;

    printf("After p++: \n");
    printf(" p: %p\n",p);
    printf(" p+1: %p\n",p+1);
    printf(" p+2: %p\n",p+2);
    printf(" p-2: %p\n",p-2);






    return 0;
}