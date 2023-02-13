/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Structure
FECHA:      13 de febrero del 2023
*/

#include <iostream>

using namespace std;

typedef struct  {

    float x;
    float y;

} punto;

typedef struct  {

    punto a;
    punto b;

} linea;

float pendiente(linea &l){
   return (l.b.y - l.a.y) / (l.b.x - l.a.x);
}

void inicializar(linea *p, float x1, float y1, float x2, float y2) {


    punto &punto1 = p -> a;
    punto &punto2 = p -> b;

    punto1.x = x1;
    punto1.y = y1;
    punto2.x = x2;
    punto2.y = y2;

    /*p -> a.x = x1;
    p -> a.y = y1;

    p -> b.x = x2;
    p -> b.y = y2;*/
}

int main(int argc, char const *argv[]){


    
    linea l;

    /*l.a.x = 5;
    l.a.y = 3;

    l.b.x = -2;
    l.b.y = -1;*/

    inicializar(&l, 5, 3, -3, -5);

    printf("Pendiente de la recta: %f\n", pendiente(l));



    return 0;
}