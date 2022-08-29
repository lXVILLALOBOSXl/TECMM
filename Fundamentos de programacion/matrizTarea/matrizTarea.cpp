#include <iostream>

using namespace std;

void fillArray();
int getNumber(int,int);
void printMatrix(int[5][5]);
void diagonalMatrix(int[5][5]);
void triangularSupMatrix(int[5][5]);
void triangularInfMatrix(int[5][5]);


int main(){
    fillArray();
    return 0;
}

void fillArray(){
    int matrix[5][5];
    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x < 5; x++)
        {
            matrix[y][x] = getNumber(y,x);
        }        
    }
    cout<<"\n"<<"a) Matriz ingresada: \n";
    printMatrix(matrix);
    cout<<"\n"<<"b) Matriz diagonal: \n";
    diagonalMatrix(matrix);
    cout<<"\n"<<"c) Matriz triangular superior: \n";
    triangularSupMatrix(matrix);
    cout<<"\n"<<"d) Matriz triangular inferior: \n";
    triangularInfMatrix(matrix);
}

void printMatrix(int matrix[5][5]){
    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x < 5; x++)
        {
            cout<<matrix[y][x]<<"\t";
        }
        cout<<endl;       
    }
}
void diagonalMatrix(int matrix[5][5]){
    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x < 5; x++)
        {
            if(x!=0 && y!=0){
                cout<<"\t";
            }
            if(x == y){
                cout<<matrix[y][x]<<"\t";
            }
        }
        cout<<endl;       
    }
}
void triangularSupMatrix(int matrix[5][5]){
    for (int y = 0; y < 5; y++)
    {
        for (int i = 0; i < y ; i++)
        {
            cout<<"\t";
        } 
        for (int x = y; x < 5; x++)
        {
            cout<<matrix[y][x]<<"\t";
        }
        cout<<endl; 
    }
}
void triangularInfMatrix(int matrix[5][5]){
    for (int y = 0; y < 5; y++)
    {
        for (int x = 0; x <= y; x++)
        {
            cout<<matrix[y][x]<<"\t";
        }
        cout<<endl;       
    }
}

int getNumber(int y, int x){

    int number;
   cout<<"Ingrese su numero, en la posicion ["<<y<<"]["<<x<<"] del arreglo: ";
    
    while (1) {
        if (cin >> number) {
            return number;
        } else {
            cout << "Entrada Invalida! Por favor ingrese un valor numerico: ";
            cin.clear();
            while (cin.get() != '\n') ; 
        }
    }
}
