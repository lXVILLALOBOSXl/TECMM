/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Holly's Queue
FECHA:      2 de marzo del 2023
*/

#include <iostream>
#include <time.h>
#include "queue.hpp"

int main(int argc, char const *argv[]){

    Queue queue(20);
    int x;

        do
        {
            scanf("%i",&x);

            if(x > 0){
                queue.enqueue(x);
                queue.print();
            }else if(x == 0){
                while (!queue.isEmpty())
                {
                    printf("%i ", queue.front());
                    queue.dequeue();
                    queue.print();
                }
            }

        } while (x > -1);

    return 0;
}