/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Hanoi
FECHA:      31 de enero del 2023
*/

#include <iostream>

using namespace std;

void hanoi(int n, char origin, char inter, char destiny){

    if(n > 0){
        hanoi(n - 1, origin, destiny, inter);
        cout<< n << " from " << origin << " -> " << destiny << endl;
        hanoi(n - 1, inter, origin, destiny);
    }

}

int main(int argc, char const *argv[])
{
    int n;
    cin>> n;
    hanoi(n, 'A', 'B', 'C');
    
    return 0;
}