// Villalobos Rivera Luis Adrian (c)
// 220120379
// 1ISC T/M

#include <iostream>
#include <string>
#include "hexadecimal.h"
#include "decimal.h"
#include "octal.h"
#include "binary.h"

using namespace std;

int menu();
int choiceNumericSystem();
string getNumber();
void suma();
void resta();
void multiplicacion();
void division();
void menuConversion();

int main()
{

    Decimal numero2 = Decimal(getNumber());
    
    int opcion = menu();

    switch (opcion)
    {
    case 1:
        suma();
        break;
    case 2:
        resta();
        break;
    case 3:
        multiplicacion();
        break;
    case 4:
        division();
        break;
    case 5:
        menuConversion();
        break;
    case 6:
        cout << "Bye!" << endl;
        break;
    }

    switch (choiceNumericSystem())
    {
    case 1:
        //Decimal numero1 = Decimal(getNumber());
        if(opcion != 5){
            Decimal numero2 = Decimal(getNumber());
        }
        break;
    case 2:
       // Hexadecimal numero1 = Hexadecimal(getNumber());
        if(opcion != 5){
            //Hexadecimal numero2 = Hexadecimal(getNumber());
        }
        break;
    case 3:
        //Octal numero1 = Octal(getNumber());
        if(opcion != 5){
            //Octal numero2 = Octal(getNumber());
        }
        break;
    case 4:
        //Binary numero1 = Binary(getNumber());
        if(opcion != 5){
            //Binary numero2 = Binary(getNumber());
        }
        break;
    }
    return 0;
}

int menu()
{
    bool error = false;

    do
    {
        int opcion;
        cout << endl
             << "Bienvenido a la calculadora de sistemas numericos" << endl
             << "Seleccione una opcion" << endl
             << "1. Sumar" << endl
             << "2. Restar" << endl
             << "3. Multiplicar" << endl
             << "4. Dividir" << endl
             << "5. Convertir" << endl
             << "6. Salir" << endl
             << "Opcion: ";
        cin >> opcion;

        if ((opcion < 1 || opcion > 6) || (cin.fail()))
        {
            error = true;
            cin.clear();
            cin.ignore(256, '\n');
            cout << "Opcion invalida" << endl;
        }
        else
        {
            error = false;
            return opcion;
        }
    } while (error);
}

int choiceNumericSystem()
{
    bool error = false;

    do
    {
        int opcion;
        cout << endl
             << "Seleccione un sistema numerico" << endl
             << "1. Decimal" << endl
             << "2. Hexadecimal" << endl
             << "3. Octal" << endl
             << "4. Binario" << endl
             << "Opcion: ";
        cin >> opcion;

        if ((opcion < 1 || opcion > 4) || (cin.fail()))
        {
            error = true;
            cin.clear();
            cin.ignore(256, '\n');
            cout << "Opcion invalida" << endl;
        }
        else
        {
            error = false;
            return opcion;
        }
    } while (error);
}

string getNumber()
{
    string number;
    cout << "Ingrese un numero: ";
    cin >> number;
    return number;
}

void suma() {}
void resta() {}
void multiplicacion() {}
void division() {}
void menuConversion() {}
