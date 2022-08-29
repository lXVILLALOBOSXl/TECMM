//Luis Adrian Villalobos Rivera 220120379 1ISC FP
//Sumatoria de A hasta B

#include <iostream>

using namespace std;

int main(){
    int numeroA, numeroB, suma=0;

    do{
      cout<<"Ingrese el numero A: ";
      cin>>numeroA;
      cout<<"Ingrese el numero B: ";
      cin>>numeroB;   
      if(numeroA>numeroB){
        cout<<"El numero A debe ser menor que el numero B, Intentelo de nuevo"<<endl;
      }
    }while (numeroA>numeroB);

    for (int i = numeroA; i < (numeroB+1); i++)
    {
        suma=suma+i;
    }
    cout<<suma<<endl;

    
    return 0;
}