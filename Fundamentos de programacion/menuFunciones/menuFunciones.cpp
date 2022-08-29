#include <iostream>

using namespace std;

//Declaracion de funciones
bool menu();
int getNumber();
bool esPar(int);
void serieNumerica(int);
int factorial(int);


int main(){
    while (!menu()){}  
    return 0;
}

//Funciona para mostrar, ingresar y verificar que el usuario ingrese una opcion de menu, y en base a su opcion
//llama la funcion correspondiente
bool menu(){

    char opcion;
    double number1;
    cout<<"\nMENU: \n"<<"1. Saber si es par o no \n"<<"2. Serie numerica \n"<<"3. Factorial \n"<<"4. Salir \n"<<"Seleccione una opcion: ";
    cin>>opcion;

    //Si eligio una opcion donde se necesite de un numero
    if(opcion == '1' || opcion == '2' || opcion == '3'){
        //Se pide el numero 
        number1 = getNumber();
    }

    switch (opcion)
    {
        case '1':
            esPar(number1);
            return false;
        case '2':
            serieNumerica(number1);
            return false;
        case '3':
            cout<<"El factroial es: "<<factorial(number1)<<endl;
            return false;
        case '4':
            cout<<"Bye!";
            return true;
        default:
            cout<<"Opcion incorrecta, intentelo de nuevo\n";
            return false;
    }
}

//Funciona para mostrar, ingresar y verificar que el usuario ingrese un numero
int getNumber(){

    int number;
    cout<<"Ingrese su numero: ";
    
    //Analiza que la entrada, si sea un valor numerico entero
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

//Verifica si un numero es par o no
bool esPar(int number){
    //Si al dividir un numero entre 2 y su residuo es cero
    if(number % 2 == 0){
        cout<<"Es par\n";
        return true;
    }else{
        cout<<"No es par\n";
        return false;
    }
}

//Realiza una serie de los numeros impares
void serieNumerica(int number){
    for (int i = 1; i <= number; i++)
    {
        cout<<i<<"\t";
        //Se aumenta uno mas para poder ser solo numeros impares 
        i++;
    }
    cout<<endl;
}

//Calcula el factorial de un numero
int factorial(int number){
    int factorial = 1;
    for (int i = 1; i <= number; i++)
    {
        factorial *= i;
    }
    return factorial;
}