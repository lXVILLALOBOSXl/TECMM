/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Index Circular Buffer
FECHA:      21 de febrero del 2023
*/

#include <iostream>

using namespace std;

// Natural index: 1, 2, 3, 4, ...., n
// int forth(int i, int n) { return i % n + 1; }

// Mod index: 0, 1, 2, 3, ...., n - 1
int forth(int i, int n) { return (i + 1) % n; }

int main(int argc, char const *argv[]){

    int n = 13;
    int i = 5;

    for (int j = 0; j < 50; j++)
    {
        cout << i << endl;

        i = forth(i,n);
    }
    

    return 0;
}