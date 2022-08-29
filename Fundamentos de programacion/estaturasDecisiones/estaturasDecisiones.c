//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include <stdio.h>

int main(){
    double estatura;
    printf("Ingrese su estatura en metros: ");
    scanf("%lf", &estatura);
    if(estatura>1.70){
        printf("Usted es una persona alta.\n");
    }
    else if(estatura<1.50){
        printf("Usted es una persona baja.\n");
    }
    else{
        printf("Usted es una persona media.\n");
    }
    return 0;
}