#include <iostream>

using namespace std;

void fillArray();
int minAge(int[10]);
int maxAge(int[10]);
int getNumber(int);

int main(){
    
    fillArray();
    return 0;
}

void fillArray(){
    int edades[10];
    for (int i = 0; i < 10; i++)
    {
       edades[i] = getNumber(i);
    }
    cout<<"La edad mas pequena es: "<<minAge(edades)<<endl;
    cout<<"La edad mas grande es: "<<maxAge(edades)<<endl;
}

int getNumber(int numeroPersona){

    int number;
    cout<<"Ingrese la edad de la persona "<<numeroPersona<<" :";
    
    while (1) {
        if (cin >> number) {
            return number;
        } else {
            cout << "Entrada Invalida! Por favor ingrese un valor numerico: ";
            cin.clear();
            while (cin.get() != '\n') ; 
        }
    }
}

int minAge(int ages[10]){
    int minNumber = ages[0];
    for (int i = 1; i < 10; i++)
    {
       if(ages[i] <= minNumber){
           minNumber = ages[i];
       }
    } 
    return minNumber;
}

int maxAge(int ages[10]){
    int maxNumber = ages[0];
    for (int i = 1; i < 10; i++)
    {
       if(ages[i] >= maxNumber){
           maxNumber = ages[i];
       } 
    } 
    return maxNumber;
}