#include <iostream>

using namespace std;

int main(){
    int numeroIngresado;
    do{
        cout<<"Ingrese desde donde contar: ";
        cin>>numeroIngresado;
        for (int i = numeroIngresado; i > -1; i--)
        {
            cout<<"Contador: "<<i<<endl;
        }
    }while(numeroIngresado < 0);
    return 0;
}