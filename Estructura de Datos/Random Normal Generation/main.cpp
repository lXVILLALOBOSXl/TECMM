/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Random Normal Generation
FECHA:      30 de enero del 2023
*/

#include <iostream>
#include <cmath>

float normal (float mu, float sigma, int k){
    
    float sum = 0.0;

    for (int i = 0; i < k; i++)
    {
        sum += float(rand()) / RAND_MAX;
    }

    sum -= float(k) / 2;

    return sigma * sum * sqrt(12.0 / k) + mu;
    
}


int main(int argc, char const *argv[])
{
    int n;
    float mu;
    float sigma;

    srand((unsigned) time(nullptr));

    scanf("%i%f%f", &n, &mu, &sigma);

    for (int i = 0; i < n; i++)
    {
        float x = normal(mu, sigma, 100);
        printf("%.2f\n", x);
    }
    

    return 0;
}
