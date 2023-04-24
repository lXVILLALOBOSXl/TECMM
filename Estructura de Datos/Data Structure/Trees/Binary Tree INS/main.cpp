/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Binary Tree Insertion
FECHA:      24 de Abril del 2023
*/

#include <iostream>
#include <time.h>
#include "tree.hpp"

int main(int argc, char const *argv[]){

    srand((unsigned) time(nullptr));

    int n = 100;

    Tree tree(n);

    while (!tree.isFull())
    {
        tree.insert(rand() % (n * 10) + 1);
    }

    tree.print();
    

    /*int n = 100; 

    Tree tree(n);

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(9);
    tree.insert(12);
    tree.insert(18);
    tree.insert(7);
    tree.insert(11);
    tree.insert(14);

    tree.print();*/

    return 0;
}