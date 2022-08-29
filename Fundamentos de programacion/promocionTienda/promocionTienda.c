//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include <stdio.h>

int main(){
    double costoPrenda1, costoPrenda2, costoPrenda3, montoAPagar;
    printf("Ingrese el costo de la prenda 1: ");
    scanf("%lf", &costoPrenda1);
    printf("Ingrese el costo de la prenda 2: ");
    scanf("%lf", &costoPrenda2);
    printf("Ingrese el costo de la prenda 3: ");
    scanf("%lf", &costoPrenda3);
    if(costoPrenda1>costoPrenda2 && costoPrenda1>costoPrenda3){
        if(costoPrenda2>costoPrenda3){
           montoAPagar = costoPrenda1 + costoPrenda2;
        }
        else{
           montoAPagar = costoPrenda1 + costoPrenda3;
        }
    }else if(costoPrenda2>costoPrenda1 && costoPrenda2>costoPrenda3){
        if(costoPrenda1>costoPrenda3){
           montoAPagar = costoPrenda2 + costoPrenda1;
        }
        else{
           montoAPagar = costoPrenda2 + costoPrenda3;
        }
    }else {
        if(costoPrenda1>costoPrenda2){
           montoAPagar = costoPrenda3 + costoPrenda1;
        }
        else{
           montoAPagar = costoPrenda3 + costoPrenda2;
        }
    }
    printf("El monto a pagar es: %lf", montoAPagar);
    return 0;
}