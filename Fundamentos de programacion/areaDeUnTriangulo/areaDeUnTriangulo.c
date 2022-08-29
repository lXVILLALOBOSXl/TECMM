//Villalobos Rivera Luis Adrian 220120379 T/M 1ºISC

#include <stdio.h>
#include <math.h>

int main(){
    float lado1, lado2, lado3, semiperimetro, area;
    printf("Ingrese el primer lado: ");
    scanf("%f", &lado1);
    printf("Ingrese el segundo lado: ");
    scanf("%f", &lado2);
    printf("Ingrese el tercer lado: ");
    scanf("%f", &lado3);
    semiperimetro = (lado1 + lado2 + lado3) / 2;
    area = sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
    printf("El area del triangulo es: %f", area);       
    return 0;
}