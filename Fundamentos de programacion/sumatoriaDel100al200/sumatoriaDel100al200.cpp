//Luis Adrian Villalobos Rivera 220120379 1ISC FP
//Sumatoria consecutiva de 100 a 200

#include <iostream>

using namespace std;

int main(){
    int suma=100;
    for (int i = 101; i < 201; i++)
    {
        suma=suma+i;
    }
    cout<<suma<<endl;
    return 0;
}