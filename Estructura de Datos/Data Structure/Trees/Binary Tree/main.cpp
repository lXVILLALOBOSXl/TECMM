/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Binary Tree Insertion
FECHA:      24 de Abril del 2023
*/

#include <iostream>
#include <time.h>
#include "tree.hpp"

using namespace std;

int main(int argc, char const *argv[])
{

    srand((unsigned) time(nullptr));

    int n = 100;

    Tree tree(n);

    while (!tree.isFull())
    {
        tree.insert(rand() % (n * 10) + 1);
    }

    tree.print();

    /*int n = 13;

    Tree tree(n);

    tree.insert(7);
    tree.insert(4);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(5);
    tree.insert(6);
    tree.insert(11);
    tree.insert(9);
    tree.insert(8);
    tree.insert(10);
    tree.insert(13);
    tree.insert(12);

    tree.print();*/

    /*int numToFind;

    cout<< "Type your number to find: ";
    cin >> numToFind;

    if(tree.find(numToFind)){
        cout<<"There is\n";
    }else{
        cout<<"There isn't\n";
    }*/

    /*int numToDelete;

    cout << "Type your number to delete: ";
    cin >> numToDelete;

    if (tree.remove(numToDelete))
    {
        cout << "Deleted succesfully\n";
    }
    else
    {
        cout << "There isn't\n";
    }

    tree.print();*/

    return 0;
}