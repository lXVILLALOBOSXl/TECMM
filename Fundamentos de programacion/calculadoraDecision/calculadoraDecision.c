//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include <stdio.h>

int main(){
    int opcion;
    double numero1, numero2, resultado;
    printf("Ingrese primer numero: ");
    scanf("%lf", &numero1);
    printf("Ingrese segundo numero: ");
    scanf("%lf", &numero2);
    printf("Menu: \n");
    printf("1. Suma\n");
    printf("2. Resta\n");
    printf("3. Multiplicacion\n");
    printf("4. Division\n");
    printf("5. Salir\n");
    printf("Opcion: ");
    scanf("%d", &opcion);
    if(opcion == 1){
        resultado = numero1 + numero2;
        printf("Suma: %lf",resultado);
    }else if(opcion == 2){
        resultado = numero1 - numero2;
        printf("Resta: %lf",resultado);
    }else if(opcion == 3){
        resultado = numero1 * numero2;
        printf("Multiplicacion: %lf",resultado);
    }else if(opcion == 4){
        resultado = numero1 / numero2;
        printf("Division: %lf",resultado);
    }else if(opcion == 5){
        printf("Bye.\n");
    }else{
        printf("Opcion incorrecta.\n");
    }
    return 0;
}