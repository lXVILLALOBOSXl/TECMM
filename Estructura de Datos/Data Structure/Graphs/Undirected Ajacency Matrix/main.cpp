/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Undirected Adjacency Matrix
FECHA:      2 de Mayo del 2023
*/

#include <iostream>
#include "graph.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    Graph G(6);

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

    printf("\nOrden del grafo: %i\n", G.order());
    printf("Tamano del grafo: %i\n", G.size());


    return 0;
}