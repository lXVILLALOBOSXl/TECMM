#include <iostream>

using namespace std;

int main(){
    int numeroIngresado;
    do{
        cout<<"Ingrese su numero hasta donde contar: ";
        cin>>numeroIngresado;
        for (int i = 1; i < numeroIngresado+1; i++)
        {
            cout<<"Contador: "<<i<<endl;
        }
    }while(numeroIngresado < 0);
    return 0;

}