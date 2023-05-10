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

Graph simpleGraph(int order)
{
    Graph graph(order);

    for (int k = 0; k < (order * 2); k++)
    {
        int i = rand() % (order - (1 - 1)) + 1;
        int j = rand() % (order - (1 - 1)) + 1;

        if(i != j && !graph.edge(i,j)){
            graph.set(i,j);
            continue;
        }

        k--;
        
    }
    
    return graph;
}

int main(int argc, char const *argv[])
{
    srand((unsigned(time(nullptr))));

    int order = 10;

    Graph graph = simpleGraph(10);

    print(graph);
    printf("\n");
    edges(graph);
    

    printf("\nGraph's order: %i\n", graph.order());
    printf("Graph's size: %i\n", graph.size());


    return 0;
}