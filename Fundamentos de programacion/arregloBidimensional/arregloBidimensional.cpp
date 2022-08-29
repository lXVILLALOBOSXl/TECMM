#include <iostream>

using namespace std;

int main(){
    int arregloBidimensional[5][5];
    int numero;

    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x < 5; x++)
        {
            cout<<"Ingrese su numero, en la posicion ["<<y<<"]["<<x<<"] del arreglo: ";
            cin>>numero;
            arregloBidimensional[y][x] = numero;
        }        
    }
    cout<<endl<<"El arreglo es: "<<endl;
    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x < 5; x++)
        {
            cout<<arregloBidimensional[y][x]<<"\t";
        }
        cout<<endl;       
    }

    return 0;
}