#include <iostream>

using namespace std;

int main(){
    int numeroIngresado, sumatoria = 0; 
    cout<<"Ingrese un numero, hasta el cual desea sumar: ";
    cin>>numeroIngresado;
    for (int i = 0; i < (numeroIngresado+1); i++)
    {
        sumatoria += i;
    }
    cout<<"La sumatoria de los numeros desde 0 hasta "<<numeroIngresado<<" es: "<<sumatoria;
    
    return 0;
}
