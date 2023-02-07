/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Cadenas
FECHA:      7 de febrero del 2023
*/

#include <iostream>

void print(const char *c){
    while (*c){
        putchar(*c++);
    }
}

int main(int argc, char const *argv[]){
    
    const char *mensaje = "hola mundo";
    print(mensaje);
    return 0;
}