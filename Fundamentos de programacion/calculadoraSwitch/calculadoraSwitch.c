//Calculadora con switch case
//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include <stdio.h>

int main(){
    int opcion;
    double numero1, numero2, resultado;
    printf("Ingrese primer numero: ");
    scanf("%lf", &numero1);
    printf("Ingrese segundo numero: ");
    scanf("%lf", &numero2);
    printf("Menu:\n");
    printf("1. Suma\n");
    printf("2. Resta\n");
    printf("3. Multiplicacion\n");
    printf("4. Division\n");
    printf("5. Salir\n");
    printf("Ingrese una opcion: ");
    scanf("%d", &opcion);
    switch(opcion){
        case 1:
            resultado = numero1 + numero2;
            printf("El resultado de la suma es: %.2lf\n", resultado);
            break;
        case 2:
            resultado = numero1 - numero2;
            printf("El resultado de la resta es: %.2lf\n", resultado);
            break;
        case 3:
            resultado = numero1 * numero2;
            printf("El resultado de la multiplicacion es: %.2lf\n", resultado);
            break;
        case 4:
            resultado = numero1 / numero2;
            printf("El resultado de la division es: %.2lf\n", resultado);
            break;
        case 5:
            printf("Saliendo...\n");
            break;
        default:
            printf("Opcion incorrecta.\n");
            break;
    }
    
}