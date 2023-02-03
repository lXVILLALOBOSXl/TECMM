/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Fibonacci
FECHA:      31 de enero del 2023
*/

#include <iostream>

using namespace std;

long fibonacci(long i){
    if(i == 1 || i == 2){
        return 1;
    }else{
        return fibonacci(i - 1)  + fibonacci (i - 2);
    }
    
}

int main(int argc, char const *argv[])
{
    /*long x;
    cin>>x;
    cout<<fibonacci(x);*/

    for (int i = 1; i <= 1; i++)
    {
        cout<< i << ":" << fibonacci(i) << endl;
    }
    
    return 0;
}