/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   References
FECHA:      13 de febrero del 2023
*/

#include <iostream>

using namespace std;

//Pass by reference
void swap(int &m, int &n){
    int aux = m;
    m = n;
    n = aux;
}

int main(int argc, char const *argv[]){

    /*int a = 5;
    int &b = a;

    cout<<"a: "<<a<<endl;
    cout<<"b: "<<b<<endl;

    a += 4;

    cout<<"a: "<<a<<endl;
    cout<<"b: "<<b<<endl;

    b -= 3;

    cout<<"a: "<<a<<endl;
    cout<<"b: "<<b<<endl;

    printf("Dirección de a: %p\n", &a);
    printf("Dirección de b: %p\n", &b);*/

    int a = 5;
    int b = 3;

    cout<<"before swap a: "<<a<<endl;
    cout<<"before swap b: "<<b<<endl;

    //Pass by reference
    swap(a,b);

    cout<<"after swap a: "<<a<<endl;
    cout<<"after swap b: "<<b<<endl;


    return 0;
}