//Luis Adrian Villalobos Rivera 220120379 1ISC FP
//Sumatoria de A hasta B

#include <iostream>

using namespace std;

int main(){
    int numeroA, numeroB;

    do{
      cout<<"Ingrese el numero A: ";
      cin>>numeroA;
      cout<<"Ingrese el numero B: ";
      cin>>numeroB;   
      if(numeroA>numeroB){
        cout<<"El numero A debe ser menor que el numero B, Intentelo de nuevo"<<endl;
      }
    }while (numeroA>numeroB);

    for (int i = numeroB; i >= numeroA; i--)
    {
        cout<<i<<endl;
    }


    
    return 0;
}