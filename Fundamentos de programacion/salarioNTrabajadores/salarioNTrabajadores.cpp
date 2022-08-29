//Luis Adrian Villalobos Rivera 220120379 1ISC FP
//salario N trabajadores
#include <iostream>

using namespace std;

int main(){
    int numeroTrabajadores, horasTrabajadas, salarioFinal;
    double  tarifaPorHora;
    do
    {
        cout<<"Ingrese el numero de trabajadores: ";
        cin>>numeroTrabajadores;
        if (numeroTrabajadores<1)
        {
            cout<<"El numero de trabajadores debe ser mayor que 0, intentelo de nuevo"<<endl;
        }
    } while (numeroTrabajadores<1);
    
    
    for (int i = 1; i < (numeroTrabajadores+1); i++)
    {
        do
        {
           cout<<"Ingrese las horas trabajadas del trabajador numero "<<i<<": ";
           cin>>horasTrabajadas;
           cout<<"Ingrese la tarifa por hora del trabajador numero "<<i<<": ";
           cin>>tarifaPorHora;
           if(horasTrabajadas<1 || tarifaPorHora<=0)
           {
               cout<<"Las horas trabajadas y la tarifa por hora deben ser mayores que 0, intentelo de nuevo"<<endl;
           }
        } while (horasTrabajadas<1 || tarifaPorHora<=0);
        salarioFinal=horasTrabajadas*tarifaPorHora;
        cout<<"El salario final del trabajador "<<i<<" : "<<salarioFinal<<endl;
    }
    
    return 0;
}
