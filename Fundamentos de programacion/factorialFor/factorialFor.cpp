#include <iostream>

using namespace std;

int main(){
    int numeroIngresado, factorial = 1;
    cout<<"Ingrese un numero, para calcular su factorial: ";
    cin>>numeroIngresado;
    for (int i = 1; i < (numeroIngresado+1); i++)
    {
        factorial *= i;
    }
    cout<<"El factorial de "<<numeroIngresado<<" es: "<<factorial;
    return 0;
}