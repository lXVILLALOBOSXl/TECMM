// Luis Adrian Villalobos Rivera 220120379 1ISC
#include <iostream>

using namespace std;

int main()
{
    int opcion;
    bool repetirMenu = true;
    do
    {
        cout << "MENU: \n"
             << "1. Opcion 1 \n"
             << "2. Opcion 2 \n"
             << "3 Opcion 3 \n"
             << "4. salir \n"
             << "Elige una opcion: ";
        cin >> opcion;
        switch (opcion)
        {
        case 1:
            cout << "Aqui va el codigo de opcion 1" << endl;
            break;
        case 2:
            cout << "Aqui va el codigo de opcion 2" << endl;
            break;
        case 3:
            cout << "Aqui va el codigo de opcion 3" << endl;
            break;
        case 4:
            cout << "Saliendo..." << endl;
            repetirMenu = false;
            break;
        default:
            cout << "Opcion no valida" << endl;
            break;
        }
    } while (repetirMenu);

    return 0;
}