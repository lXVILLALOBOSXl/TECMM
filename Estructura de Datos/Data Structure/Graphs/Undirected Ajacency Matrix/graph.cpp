/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Undirected Adjacency Matrix
FECHA:      2 de Mayo del 2023
*/

#include "graph.hpp"

void Graph::swap(int &a, int &b){
    int c = a;
    a = b;
    b = c;
}

int Graph::index(int i, int j){

    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if(j > i){
        swap(i,j);
    }

    return ((((i-1) * (i-2)) / 2) + j) - 1;


}

Graph::Graph(int ord){
    n = ord;
    s = 0;

    E = new bool[n * (n - 1) / 2];
}

Graph::~Graph(){
    delete [] E;
}

void Graph::set(int i, int j){

    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if(!edge(i,j)){
        E[index(i,j)] = true;
        s++;
    }

}

void Graph::unset(int i, int j){
    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if(edge(i,j)){
        E[index(i,j)] = false;
        s--;
    }

}

bool Graph::edge(int i, int j){
    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    return E[index(i,j)];
}


void print(Graph &G){

    for (int i = 1; i <= G.order(); i++)
    {
        printf("%i  ",i);
        for (int j = 1; j <= G.order(); j++)
        {
            if(i == j){
                printf("0 ");
            }else{
                printf("%i ", G.edge(i,j));
            }
        }
        printf("\n");
        
    }

    printf("\n   ");
    for (int i = 1; i <= G.order(); i++)
    {
        printf("%i ",i);
    }
    printf("\n");
    
    

}