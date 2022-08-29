// Luis Adrian Villalobos Rivera 220120379 1ISC
#include <iostream>

using namespace std;

int main()
{
    int opcion = 1;
    while (opcion != 4)
    {
        cout << "MENU: \n"
             << "1. Opcion 1 \n"
             << "2. Opcion 2 \n"
             << "3 Opcion 3 \n"
             << "4. salir \n"
             << "Elige una opcion: ";
        bool opcionValida = false;
        while (!opcionValida)
        {
            cin >> opcion;
            if(opcion >= 1 && opcion <= 4)
            {
                opcionValida = true;
            }
            else
            {
                cout << "Opcion no valida" << endl;
            }
        }
        if(opcion == 1)
        {
            cout << "Aqui va el codigo de opcion 1" << endl;
        }
        else if(opcion == 2)
        {
            cout << "Aqui va el codigo de opcion 2" << endl;
        }
        else if(opcion == 3)
        {
            cout << "Aqui va el codigo de opcion 3" << endl;
        }
        else if(opcion == 4)
        {
            cout << "Saliendo..." << endl;
        }
        
    }


    return 0;
}