//Villalobos Rivera Luis Adrian 220120379 T/M 1ºISC

#include <stdio.h>

int main()
{
    float centigrados, fahrenheit;
    printf("Ingrese los grados centigrados: ");
    scanf("%f", &centigrados);
    fahrenheit = (centigrados * 9/5) + 32;
    printf("%f grados centigrados son %f grados fahrenheit", centigrados, fahrenheit);
    return 0;
}