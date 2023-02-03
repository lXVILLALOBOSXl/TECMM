#include <iostream>

float squareRoot(float x, int n);
float squareRoot(int a, int b, int n);

int main() {

  float x;
  int n;

  scanf("%f%i", &x, &n);

  printf("%.6f", squareRoot(x, n));

  return 0;
}

float squareRoot(float x, int n) {
  int a = 0, b;

  while ((a * a) <= (int)x) {
    if ((a * a) == (int)x) {
      a++;
      break;
    }
    a++;
  }
  a--;
  b = x - (a * a);

  return squareRoot(a, b, n);
}

float squareRoot(int a, int b, int n) {
  if (n == 0) {
    return 1.0;
  }
  return a + (b / squareRoot(2 * a, b, n - 1));
}
