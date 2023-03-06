/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Game of Two
FECHA:      10 de marzo del 2023
*/

#include <iostream>
#include <time.h>
#include "queue.hpp"

int main(int argc, char const *argv[]){

    srand((unsigned (time(nullptr))));

    char coin;
    int n, count = 0;
    scanf("%i",&n);
    Queue q(n);

    while ((count < (n * 4)) && (!q.isFull()))
    {
        count++;

        coin = ((rand() % 2) == 1) ? 'x' : 'o';

        if (coin == 'o')
        {
            int toAdd = rand() % (10 * n) + 1;
            printf("%c  %2i: ",coin,toAdd);
            q.enqueue(toAdd);
        }else if(q.size() == 0){
            printf("%c  %2i: ",coin,0);
        }else {
            printf("%c  %2i: ",coin,q.front());
            q.dequeue();
        }

        q.print();
    
    }

    if(q.isFull()){
        printf("\nYou lost %i points\n", q.count());
    }else{
        printf("\nYou won %i points\n", q.count());
    }
    
    return 0;
}