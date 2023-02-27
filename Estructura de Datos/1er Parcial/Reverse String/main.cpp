/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#include <iostream>
#include "stack.hpp"

using namespace std;

int main(int argc, char const *argv[]){    

    string str;
    getline(cin, str);
    
    Stack stack(100);

    for (int i = 0; i < str.length(); i++)
    {
        stack.push(str[i]);
    }
    
    string reversed = "";

    while (!stack.isEmpty()) {

        reversed += stack.top();
        stack.pop();

    }

    cout<<reversed<<endl;

    return 0;
}

