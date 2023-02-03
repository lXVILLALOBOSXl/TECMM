/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Números aleatorio
FECHA:      30 de enero del 2023
*/

#include "random/random.h"
#include "util/util.h"
#include <iostream>

using namespace std;

int main(int argc, char *argv[]) {
  
  int n, min, max, p;

  n = askInteger("numbers quantity", true);
  p = askInteger("precession", true);
  min = askInteger("min value (included)", false);
  max = askInteger("max value (included)", false);

  while (max <= min) {
    cout << "max value should be greather than " << min << "\n";
    max = askInteger("max value (included)", false);
  }

  initialize();

  for (int i = 0; i < n; i++) {
    cout << randomFloat(min, max, p) << "\n";
  }
  return 0;
}