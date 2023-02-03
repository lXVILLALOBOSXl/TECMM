#include "random.h"

void initialize() { srand(time(NULL)); }

float randomFloat(int min, int max, int p) {
  int intPart = rand() % (max - (min - 1)) + min;
  if (intPart == max) {
    intPart--;
  }
  float decimal = (float)(rand() % (int)pow(10, p)) / pow(10, p);
  return intPart + decimal;
}