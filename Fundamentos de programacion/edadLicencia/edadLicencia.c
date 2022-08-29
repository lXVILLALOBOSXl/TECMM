//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include <stdio.h>

int main(){
    int edad;
    printf("Ingrese su edad: ");
    scanf("%d", &edad);
    if(edad>=18){
        printf("Usted puede tramitar su licencia.\n");
    }
    else{
        printf("Usted NO puede tramitar su licencia.\n");
    }
}