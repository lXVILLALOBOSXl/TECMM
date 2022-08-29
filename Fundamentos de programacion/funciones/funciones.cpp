#include <iostream>

using namespace std;

bool menu();
double suma(double, double);
double resta(double, double);
double multiplicacion(double, double);
double division(double, double);
double getNumber();

int main(){
    
    while (!menu()){}
    
    
    return 0;
}

bool menu(){

    char opcion;
    double number1, number2;
    cout<<"\nMENU: \n"<<"1. Suma \n"<<"2. Resta \n"<<"3. Multiplicacion \n"<<"4. Division \n"<<"5. Salir \n"<<"Seleccione una opcion: ";
    cin>>opcion;
    if(opcion == '1' || opcion == '2' || opcion == '3' || opcion == '4'){
        number1 = getNumber();
        number2 = getNumber();
    }

    switch (opcion)
    {
        case '1':
            cout<<"El resultado es: "<<suma(number1, number2)<<endl;
            return false;
        case '2':
            cout<<"El resultado es: "<<resta(number1, number2)<<endl;
            return false;
        case '3':
            cout<<"El resultado es: "<<multiplicacion(number1, number2)<<endl;
            return false;
        case '4':
            cout<<"El resultado es: "<<division(number1, number2)<<endl;
            return false;
        case '5':
            cout<<"Bye!";
            return true;
        default:
            cout<<"Opcion incorrecta, intentelo de nuevo\n";
            return false;
    }
}

double getNumber(){

    double number;
    cout<<"Ingrese su numero: ";
    
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

double suma(double a, double b){
    return a + b;
}

double resta(double a, double b){
    return a - b;
}

double multiplicacion(double a, double b){
    return a * b;
}

double division(double a, double b){
    return a / b;
}