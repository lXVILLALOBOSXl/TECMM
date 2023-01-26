#include <cstdio>
#include <cstdlib>
#include <ctime>


int main(){

    srand(time(NULL));

    for (int i = 0; i < 10; i++)
    {
        int x  = rand() % (94 - (47 - 1)) + 47;
        printf("x: %i\n", x);
        double y = (double)(rand() % 1000) / 1000;
        printf("y: %f\n", y);
    
    }
    
    
    return 0;
}