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


    Graph::edges(graph);
    printf("\n");

    int source = rand() % (order - (1 - 1)) + 1;
    int target = rand() % (order - (1 - 1)) + 1;

    printf("DFS From %i to %i:\n", source, target);
    Graph::dfs(graph,source, target).print();

    printf("BFS From %i to %i: %d\n", source, target,Graph::bfs(graph,source, target));

    printf("SP From %i to %i:\n", source, target);
    Graph::sp(graph,source, target).print();
    
    
    


    return 0;
}