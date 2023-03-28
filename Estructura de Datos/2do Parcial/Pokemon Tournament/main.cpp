/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Pokemon's Tournament
FECHA:      31 de Marzo del 2023
*/

#include <iostream>
#include <time.h>
#include "heap.hpp"

void fill(Heap &heap, int n)
{

    for (int i = 0; i < n; i++)
    {
        heap.insert(rand() % (4 * n) + 1);
    }
}

void battle(Heap &player1, Heap &player2)
{

    int pointsP1, pointsP2;

    pointsP1 = player1.takeOut();
    pointsP2 = player2.takeOut();

    printf("k:%i Vs. o:%i | ", pointsP1, pointsP2);

    if (pointsP1 > pointsP2)
    {
        printf("Ketchum wins\n");
        pointsP1 = pointsP1 - pointsP2;
        player1.insert(pointsP1);
    }
    else if (pointsP2 > pointsP1)
    {
        printf("Oak wins\n");
        pointsP2 = pointsP2 - pointsP1;
        player2.insert(pointsP2);
    }
    else
    {
        printf("Nobody wins\n");
    }
}

void tournament(Heap &player1, Heap &player2)
{

    printf("\nTournament starts\n\n");

    while (!(player1.isEmpty()) && !(player2.isEmpty()))
    {
        battle(player1, player2);
    }

    if (player1.isEmpty() && !(player2.isEmpty()))
    {
        printf("\nKetchum is out of pokes!\n");
        printf("Oak wins the tournament!\n");
    }
    else if (player2.isEmpty() && !(player1.isEmpty()))
    {
        printf("\nOak is out of pokes!\n");
        printf("Ketchum wins the tournament!\n");
    }
    else
    {
        printf("\nNo one has pokes left!\n");
        printf("Nobody wins, it's a tie!\n");
    }
}

int main(int argc, char const *argv[])
{

    srand((unsigned(time(nullptr))));

    int n;
    scanf("%d", &n);

    Heap ketchum(n);
    Heap oak(n);

    fill(ketchum, n);
    fill(oak, n);

    printf("Ketchum:    ");
    ketchum.print();
    printf("Oak:        ");
    oak.print();

    tournament(ketchum, oak);

    return 0;
}