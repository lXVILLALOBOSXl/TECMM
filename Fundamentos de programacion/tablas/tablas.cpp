// Luis Adrian Villalobos Rivera 220120379 1ISC
#include <iostream>

using namespace std;

int main() {
    for (int i = 0; i < 13; i++)
    {
        cout << "Tabla del " << i << ": " << endl;
        for (int j = 0; j < 11; j++)
        {
            cout << i << " X " << j << " = " << i * j << endl;
        }
        cout<<endl;
    }
    
    return 0;
}