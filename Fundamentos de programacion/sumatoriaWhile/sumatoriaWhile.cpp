#include <iostream>

using namespace std;

int main(){
    int numeroIngresado, contador = 0, sumatoria = 0;
    cout<<"Ingrese un numero, hasta el cual desea sumar: ";
    cin>>numeroIngresado;
    while (contador < (numeroIngresado+1))
    {
        sumatoria += contador;
        contador++;
    }
    cout<<"La sumatoria de los numeros desde 0 hasta "<<numeroIngresado<<" es: "<<sumatoria;
    
    return 0;
}