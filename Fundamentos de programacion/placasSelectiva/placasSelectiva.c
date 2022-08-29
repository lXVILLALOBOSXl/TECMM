//Luis Adrian Villalobos Rivera 1ºISC 220120379 T/M
#include<stdio.h>

int main(){
    int terminacionDePlaca;
    printf("Ingrese la terminacion de su placa: ");
    scanf("%d", &terminacionDePlaca);
    if(terminacionDePlaca == 1 || terminacionDePlaca == 2){
        printf("El color de su placa es amarillo\n");
        printf("No circula en lunes\n");
    }
    else if(terminacionDePlaca == 3 || terminacionDePlaca == 4){
        printf("El color de su placa es rosa\n");
        printf("NO circula en martes\n");
    }
    else if(terminacionDePlaca == 5 || terminacionDePlaca == 6){
        printf("El color de su placa es rojo\n");
        printf("No circula en miercoles\n");
    }
    else if(terminacionDePlaca == 7 || terminacionDePlaca == 8){
        printf("El color de su placa es verde\n");
        printf("Circula en jueves\n");
    }
    else if(terminacionDePlaca == 9 || terminacionDePlaca == 0){
        printf("El color de su placa es azul\n");
        printf("No circula en viernes\n");
    }else{
        printf("Dato incorrecto\n");
    }
    return 0;
}