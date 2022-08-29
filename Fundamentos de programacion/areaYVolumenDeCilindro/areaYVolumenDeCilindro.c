//Villalobos Rivera Luis Adrian 220120379 T/M 1ºISC

#include <stdio.h>
#include <math.h>

int main(){
    float radio, altura, volumen, area;
    printf("Ingrese el radio del cilindro: ");
    scanf("%f", &radio);
    printf("Ingrese la altura del cilindro: ");
    scanf("%f", &altura);
    volumen = M_PI * pow(radio, 2) * altura;
    area = 2 * M_PI * radio * (radio + altura);
    printf("El volumen del cilindro es: %f", volumen);
    printf("El area del cilindro es: %f", area);
    return 0;
}