/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Binary Trees
FECHA:      22 de mayo del 2023
*/

#include <iostream>
#include "set.hpp"

using namespace std;

void fill(Set &, int);
bool operations(char, Set &);

int main(int argc, char const *argv[])
{

    srand((unsigned(time(nullptr))));

    int n;
    cin >> n;

    Set set(100);
    fill(set, n);

    char option;

    do
    {
        cout << "\n[I] Insert\n[M] Member\n[S] Supress\n[C] Clean\n[L] List\n[X] Exit\n";
        cin >> option;
    } while (operations(option, set));

    return 0;
}

void fill(Set &set, int n)
{

    for (int i = 0; i < n; i++)
    {
        set.insert(rand() % (10 * n) + 1);
    }
}

bool operations(char option, Set &set)
{

    char yesOrNo;
    int number;

    switch (option)
    {
    case 'I':

        cout << "\ndatum: ";
        cin >> number;
        set.insert(number);
        cout << "Set: ";
        set.print();

        return true;

    case 'M':

        cout << "\ndatum: ";
        cin >> number;
        if (set.member(number))
        {
            cout << number << ", is member\n";
        }
        else
        {
            cout << number << ", isn't member\n";
        }

        return true;

    case 'S':

        cout << "\ndatum: ";
        cin >> number;
        if (set.member(number))
        {
            cout << number << ", is member, do you want to delete it?\n[Y] Yes\n[N] No\n";
            cin >> yesOrNo;

            if (yesOrNo == 'Y')
            {
                set.remove(number);
                cout << "\nSet: ";
                set.print();
            }
            else if (yesOrNo == 'N')
            {
            }
        }else{
            cout << number << ", isn't member\n";
        }

        return true;
    case 'C':

        cout << "\nDo you want to clean the set?\n[Y] Yes\n[N] No\n";
        cin >> yesOrNo;

        if (yesOrNo == 'Y')
        {
            cout << "\nOki :'(\n";
            set.clean();
        }

        return true;
    case 'L':
        cout << "\nSet: ";
        set.print();
        return true;
    case 'X':
        cout << "\nOk, bye";
        return false;
    default:
        return true;
    }
}