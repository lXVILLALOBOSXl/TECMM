/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Undirected Adjacency Matrix
FECHA:      2 de Mayo del 2023
*/

#include "graph.hpp"

void Graph::swap(int &a, int &b)
{
    int c = a;
    a = b;
    b = c;
}

int Graph::index(int i, int j)
{

    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if (j > i)
    {
        swap(i, j);
    }

    return ((((i - 1) * (i - 2)) / 2) + j) - 1;
}

Graph::Graph(int ord)
{
    n = ord;
    s = 0;

    E = new bool[n * (n - 1) / 2];
}

Graph::~Graph()
{
    delete[] E;
}

void Graph::set(int i, int j)
{

    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if (!edge(i, j))
    {
        E[index(i, j)] = true;
        s++;
    }
}

void Graph::unset(int i, int j)
{
    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    if (edge(i, j))
    {
        E[index(i, j)] = false;
        s--;
    }
}

bool Graph::edge(int i, int j)
{
    assert(1 <= i and i <= n);
    assert(1 <= j and j <= n);
    assert(i != j);

    return E[index(i, j)];
}

void Graph::print(Graph &G)
{

    for (int i = 1; i <= G.order(); i++)
    {
        for (int j = 1; j <= G.order(); j++)
        {
            if (i == j)
            {
                printf("0 ");
            }
            else
            {
                printf("%i ", G.edge(i, j));
            }
        }
        printf("\n");
    }
}

void Graph::edges(Graph &G)
{

    for (int i = 1; i <= G.order(); i++)
    {
        for (int j = 1; j <= i; j++)
        {
            if (i != j && G.edge(i, j))
            {
                printf("%i-%i\n", j, i);
            }
        }
    }
}

Stack Graph::dfs(Graph &g, int source, int target)
{

    Graph rute(g.size());
    Tree M(g.size());
    Stack stack(g.size());
    int u;
    int v;
    int smallest = 0;

    stack.push(source);
    while (!stack.isEmpty())
    {
        u = stack.top();
        M.insert(u);

        for (int i = 1; i <= g.order(); i++)
        {
            if (i != u && g.edge(i, u) && !M.find(i))
            {
                if (smallest < 1 || i < smallest)
                {
                    smallest = i;
                    v = i;
                }
            }
        }

        smallest = 0;

        if (v > 0 && !M.find(v))
        {
            stack.push(v);
            if (v == target)
            {
                return stack;
            }
        }
        else
        {
            stack.pop();
        }
    }
    return stack;
}

bool Graph::bfs(Graph &g, int source, int target)
{
}

Stack Graph::sp(Graph &g, int source, int target)
{
}
