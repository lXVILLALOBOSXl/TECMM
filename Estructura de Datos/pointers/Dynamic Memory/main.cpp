/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic memory managment
FECHA:      13 de febrero del 2023


programa de estados, si fuera con if else seria un código estructurado
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

    return p;
}

int main(int argc, char const *argv[]){

    node *n[11]; //[] indexador operator


    /*int a = 5; //time execution creting object
    int *p = &a; 
    int *p2 = p;*/

    n[0] = crear("DOES THE DAMN THING WORK");
    n[1] = crear("DON'T F*CK WITH IT");
    n[2] = crear("DID YOU F*CK WITH IT?");
    n[3] = crear("DOES ANYONE KNOW?");
    n[4] = crear("YOU DUMB SH*T");
    n[5] = crear("Hide it");
    n[6] = crear("YOU POOR BAST*RD");
    n[7] = crear("WILL YOU CATCH HELL?");
    n[8] = crear("CAN YOU BLAME SOMEONE ELSE?");
    n[9] = crear("SH*T CAN IT");
    n[10] = crear("NO PROBLEM");

    n[0] -> yes = n[1];
    n[0] -> no = n[2];

    n[1] -> yes = n[10];
    n[1] -> no = n[1];
    
    n[2] -> yes = n[4];
    n[2] -> no = n[7];

    n[3] -> yes = n[6];
    n[3] -> no = n[5];

    n[4] -> yes = n[3];
    n[4] -> no = n[4];

    n[5] -> yes = n[10];
    n[5] -> no = n[10];

    n[6] -> yes = n[8];
    n[6] -> no = n[6];

    n[7] -> yes = n[6];
    n[7] -> no = n[9];

    n[8] -> yes = n[10];
    n[8] -> no = n[6];

    n[9] -> yes = n[10];
    n[9] -> no = n[9];

    node *p = n[0];
    char c;
    
    do
    {

        cout<<p -> mssg<<endl;

        if(p == n[10]){
            p = nullptr;
        }else{
            cin>>c;
            p = ((c == 'y') ? p -> yes : p -> no);
        }


    } while (p);

    for (int i = 0; i < 11; i++)
    {
        delete n[i];
    }
    
    

    return 0;
}