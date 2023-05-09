/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Undirected Adjacency Matrix
FECHA:      2 de Mayo del 2023
*/

#include <iostream>
#include <time.h>
#include "graph.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    srand((unsigned(time(nullptr))));

    int order = 20;

    Graph G(order);

    G.set(1,3);
    G.set(1,6);
    G.set(2,3);
    G.set(2,4);
    G.set(2,5);
    G.set(3,5);
    G.set(4,5);
    G.set(4,6);
    G.set(5,6);

    print(G);

    printf("\nGraph's order: %i\n", G.order());
    printf("TGraph's size: %i\n", G.size());


    return 0;
}