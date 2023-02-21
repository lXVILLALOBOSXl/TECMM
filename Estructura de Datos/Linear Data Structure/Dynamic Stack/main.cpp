/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Circular Buffer
FECHA:      21 de febrero del 2023
*/

/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#include <iostream>
#include <time.h>
#include "stack.hpp"

int main(int argc, char const *argv[]){    

    srand((unsigned) time(nullptr));

    int n = 10;
    Stack s(n);

    for (int i = 0; i < n * 2; i++)
    {
        int option = rand() % 2;


        //Insertion
        if(option == 0){


            if(s.isFull()) {
                printf("The stack is full\n");
            }else{

                int x = rand() % (10 * n) + 1;
                printf("Push %i: ", x);

                s.push(x);
                s.print();
            }

        

        }else{ //Extraction

            if(s.isEmpty()) {
                printf("The stack is empty\n");
            }else{

                int x = s.top();
                s.pop();

                printf("Pop %i: ", x);
                s.print();

            }

    
        }

    }

    cout<< "\nFinal content Stack:\n";
    s.print();

    while (!s.isEmpty()){
        int x = s.top();
        s.pop();

        printf("Pop %i: ", x);
        s.print();
    }

    

    /*for (int i = 0; i < n; i++)
    {
        int x = rand() % (10 * n) + 1;
        printf("Push %i: ", x);
        
        s.push(x);
        s.print();

    }

    for (int i = 0; i < n; i++)
    {

        int x = s.top();
        s.pop();

        printf("Pop %i: ", x);
        s.print();
        
    }*/

    return 0;
}