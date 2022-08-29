#include <iostream>

using namespace std;

int main(){
    int numeroIngresado, factorial = 1, contador = 1;
    cout<<"Ingrese un numero, para calcular su factorial: ";
    cin>>numeroIngresado;
    while (contador < (numeroIngresado+1))
    {
        factorial *= contador;
        contador++;
    }
    cout<<"El factorial de "<<numeroIngresado<<" es: "<<factorial;
    return 0;
}
