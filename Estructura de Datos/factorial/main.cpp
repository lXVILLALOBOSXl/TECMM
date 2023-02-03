/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Factorial
FECHA:      31 de enero del 2023
*/

#include <iostream>

using namespace std;

long factorial(long x){
    if(x == 0){
        return 1;
    }else{
        return x * factorial(x - 1);
    }
}

int main(int argc, char const *argv[])
{

    long x;
    cin>>x;
    cout<< factorial(x);

    return 0;
}