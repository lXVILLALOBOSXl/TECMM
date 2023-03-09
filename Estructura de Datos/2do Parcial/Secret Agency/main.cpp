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
string getKey();
Record create();
Record create(string, string, int, string);
void print(Record record);

int main(int argc, char const *argv[])
{

    List list(23);
    list.insert(create("Chuck Aule", "Mark Ruffalo", 42, "United Kingdom"));
    list.insert(create("Teddy Daniels", "Leonardo DiCaprio", 41, "United States"));
    list.insert(create("John Cawley", "Bing Kingsley", 50, "Irlanda"));

    char option;

    do
    {
        cout << "\n[A] Add Agent\n[F] Find Agent\n[D] Delete Agent\n[S] Show Agents\n[X] Exit\n";
        cin >> option;
    } while (operations(option, list));

    return 0;
}

string getKey()
{
    string key;
    cout << "\nType Agent's key:\n\nKey     :     ";
    getline(cin >> ws, key);
    return key;
}

bool operations(char option, List &list)
{

    Record record;
    string key;
    char toDelete;

    switch (option)
    {
    case 'A':
        if (!list.insert(create()))
        {
            cout << "\nKey already in use\n";
        }
        return true;
    case 'F':
        if (list.find(getKey(), record))
        {
            print(record);
        }
        else
        {
            cout << "\nNo matches\n";
        }
        return true;
    case 'D':
        key = getKey();
        if (list.find(key, record))
        {
            print(record);
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
    getline(cin >> ws, r.key);
    cout << "Real Name: ";
    getline(cin >> ws, r.name);
    cout << "Age:       ";
    cin >> r.age;
    cout << "Country:   ";
    getline(cin >> ws, r.country);
    return r;
}

Record create(string _key, string _name, int _age, string _country)
{
    Record r;
    r.key = _key;
    r.name = _name;
    r.age = _age;
    r.country = _country;
    return r;
}

void print(Record record)
{
    cout << "\nKey Name   :  " << record.key
         << "\nReal Name  :  " << record.name
         << "\nAge        :  " << record.age
         << "\nCountry    :  " << record.country << "\n";
}