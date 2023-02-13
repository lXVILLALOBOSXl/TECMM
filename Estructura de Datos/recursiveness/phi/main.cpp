/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Phi
FECHA:      31 de enero del 2023
*/

#include <iostream>

using namespace std;

double phi(int n){
    if(n == 0){
        return 1;
    }
    return 1.0 + 1.0 / phi(n-1);
}

int main(int argc, char const *argv[])
{
    int n;
    cin>>n;
    cout<<phi(n);
    
    
    return 0;
}