/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Secret Agency
FECHA:      14 de marzo del 2023
*/

#include <iostream>
#include "list.hpp"

using namespace std;

bool operations(char, List &);
char getOption();
string getKey();
void printRecord(Record record);
Record create();

int main(int argc, char const *argv[])
{

    List list(10);

    do
    {
        cout << "\n[A] Add Agent\n[F] Find Agent\n[D] Delete Agent\n[S] Show Agents\n[X] Exit\n";
    } while (operations(getOption(), list));

    return 0;
}

char getOption()
{
    char option;
    cin >> option;
    return option;
}

string getKey()
{
    string key;
    cout << "\nType Agent's key:\n\nKey     :  ";
    cin >> key;
    return key;
}

void printRecord(Record record)
{
    cout << "\nKey Name :" << record.key
         << "\nReal Name  :  " << record.name
         << "\nAge        :  " << record.age
         << "\nCountry    :  " << record.country<<"\n";
}

bool operations(char option, List &list)
{

    Record record;
    string key;
    char toDelete;

    switch (option)
    {
    case 'A':
        list.insert(create());
        return true;
    case 'F':
        if (list.find(getKey(), record))
        {
            printRecord(record);
        }
        else
        {
            cout << "\nNo matches";
        }
        return true;
    case 'D':
        key = getKey();
        if (list.find(key, record))
        {
            printRecord(record);
            cout << "\nDelete record (Y/N) ? ";
            cin >> toDelete;
            if (toDelete == 'Y')
            {
                list._delete(key);
            }
        }
        return true;
    case 'S':
        list.print();
        return true;
    case 'X':
        return false;
    default:
        return true;
    }
}

Record create()
{
    Record r;
    cout << "\nType new agent's data:\n\nKey Name:  ";
    cin >> r.key;
    cout << "Real Name: ";
    cin >> r.name;
    cout << "Age:       ";
    cin >> r.age;
    cout << "Country:   ";
    cin >> r.country;
    return r;
}