#include <iostream>

using namespace std;

int main(){
    bool bandera = true;
    double numeroIngresado, suma = 0;
    int cantidadDeNumeros = 0;
    do
    {
        cout<<"Ingrese su numero "<<cantidadDeNumeros+1<<" : ";
        cin>>numeroIngresado;
        if (numeroIngresado <= 0)
        {
            bandera = false;
            if(cantidadDeNumeros == 0){
                cantidadDeNumeros++;
            }
        }else{
            suma += numeroIngresado;
            cantidadDeNumeros++;
        }
    } while (bandera == true);
    cout<<"El promedio de sus "<<cantidadDeNumeros<<" numeros es : "<<suma / cantidadDeNumeros;
    return 0;
}