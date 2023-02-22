/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Circular Buffer
FECHA:      20 de febrero del 2023
*/

#include <iostream>
#include <time.h>
#include "queue.hpp"

using namespace std;

int main(int argc, char const *argv[]){
    
    srand((unsigned) time(nullptr));
    int n = 10;
    Queue queue(n);

    /*for (int i = 0; i < n * 2; i++)
    {
        int option = rand() % 2;


        //Insertion
        if(option == 0){


            if(queue.isFull()) {
                printf("The stack is full\n");
            }else{

                int x = rand() % (10 * n) + 1;
                printf("Enqueue %i: ", x);

                queue.enqueue(x);
                queue.print();
            }

        

        }else{ //Extraction

            if(queue.isEmpty()) {
                printf("The stack is empty\n");
            }else{

                int x = queue.front();
                queue.dequeue();

                printf("Dequeue %i: ", x);
                queue.print();

            }

    
        }

    }*/

    for (int i = 0; i < n; i++)
    {
        int x = rand() % (10 * n) + 1;
        printf("Enqueue %i: ", x);
        
        queue.enqueue(x);
        queue.print();

    }

    for (int i = 0; i < n; i++)
    {

        int x = queue.front();
        queue.dequeue();

        printf("Dequeue %i: ", x);
        queue.print();
        
    }

    return 0;
}