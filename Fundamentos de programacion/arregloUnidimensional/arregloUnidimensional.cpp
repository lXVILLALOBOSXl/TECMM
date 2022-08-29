#include <iostream>

using namespace std;

int main(){
    int arregloUnidimensional[5];
    int numero;

    for (int i = 0; i < 5; i++)
    {
        cout<<"Ingrese su numero, en la posicion "<<i<<" del arreglo: ";
        cin>>numero;
        arregloUnidimensional[i] = numero;
    }

    cout<<"Su arreglo es: "<<endl;
    
    for (int i = 0; i < 5; i++)
    {
        cout<<arregloUnidimensional[i]<<"\t";
    }

    return 0;
}