/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Undirected Adjacency Matrix
FECHA:      2 de Mayo del 2023
*/

#ifndef graph_hpp
#define graph_hpp

#include <iostream>
#include <assert.h>
#include "queue.hpp"
#include "stack.hpp"
#include "tree.hpp"

using namespace std;

class Graph
{
    bool *E;

    int n; // Orden del grafo
    int s; // Cantidad de Aristas

    int index(int, int);
    void swap(int &, int &);

public:

    Graph(int);
    ~Graph();

    void set(int,int);
    void unset(int,int);
    bool edge(int,int);

    int order() const {return n;};
    int size() const {return s;};

    static void print(Graph &);
    static void edges(Graph &);

    static Stack dfs(Graph &, int, int);
    static bool bfs(Graph &, int, int);
    static Stack sp(Graph &, int, int);

};

#endif