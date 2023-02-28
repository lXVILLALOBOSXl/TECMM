/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Ordered list
FECHA:      27 de febrero del 2023
*/

#include <iostream>
#include "list.hpp"

int main(int argc, char const *argv[]){    

    List list(10);
    int x;

    do
    {
        scanf("%i",&x);
        if(x > 0){
            list.insert(x);
            list.print();
        }

    } while (x != 0);

    do
    {
        scanf("%i",&x);

        if(list._delete(x)){
            printf("Item %i removed ",x);
            list.print();
            continue;
        }

        printf("Item %i not funded \n",x);
    }while (x != 0);

    return 0;
}