/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic memory managment
FECHA:      13 de febrero del 2023
*/

#include <iostream>

using namespace std;

typedef struct snode {

    const char *mssg;

    snode *yes;
    snode *no;

} node;

node *crear(const char *m){
    node *p = new node; 
    p -> mssg = m;
    p -> yes = nullptr;
    p -> no = nullptr;
}

int main(int argc, char const *argv[]){
    node *n1 = crear("DOES THE DAMN THING WORK");
    node *n2 = crear("DON'T FUCk WITH IT");
    node *n3 = crear("DID YOU FUCK WITH IT?");
    node *n4 = crear("DOES ANYONE KNOW?");
    node *n5 = crear("YOU DUMB SHIT");
    node *n6 = crear("Hide it");
    node *n7 = crear("YOU POOR BASTARD");
    node *n8 = crear("WILL YOU CATCH HELL?");
    node *n9 = crear("CAN YOU BLAME SOMEONE ELSE?");
    node *n10 = crear("SHIT CAN IT");
    node *n11 = crear("NO PROBLEM");

    return 0;
}