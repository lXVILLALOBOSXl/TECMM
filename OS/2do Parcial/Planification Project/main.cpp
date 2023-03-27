#include <iostream>
#include <string>
#include "list.hpp"
#include "process.hpp"
#include "planification.hpp"

using namespace std;

bool operations(int, List<Process>);
List<Process> createProcessList();
Process createProcess();
int askInteger(const char *, bool);

int main(int argc, char const *argv[])
{

    List<Process> list;
    do
    {
        list = createProcessList();
        cout << "\n[1] FIFO\n[2] SJF\n[3] PRIORITY\n[4] ROUND ROBIN\n[5] Exit\n";
    } while (operations(askInteger("option", true), list));

    return 0;
}

bool operations(int option, List<Process> processes)
{

    switch (option)
    {
    case 1:
        cout << "---------------------FIFO-------------------------------\n";
        cout << Planification::fifo(processes);
        return true;
    case 2:
        cout << "---------------------SJF--------------------------------\n";
        cout << Planification::sjf(processes);
        return true;
    case 3:
        cout << "---------------------PRIORITY---------------------------\n";
        cout << Planification::priority(processes);
        return true;
    case 4:
        cout << "---------------------Round Robin------------------------\n";
        cout << Planification::roundRobin(processes);
        return true;
    case 5:
        return false;
    default:
        cout << "\nIncorrect option, try again.\n";
        return true;
    }
}

List<Process> createProcessList()
{
    List<Process> list;
    int processNumber = askInteger("number of process", true);
    for (int i = 0; i < processNumber; i++)
    {
        list.insert(createProcess());
    }
    return list;
}

Process createProcess()
{
    return Process(askInteger("time", true), askInteger("priority", true));
}

int askInteger(const char *message, bool onlyPositive)
{
    int number;
    if (onlyPositive)
    {

        while (cout << "Type a correct " << message << ": ",
               !(cin >> number) || number < 0)
        {
            cerr << "Input error, try again. \n";
            if (cin.fail())
            {
                cin.clear();
                cin.ignore();
            }
        }
    }
    else
    {
        while (cout << "Type a correct " << message << ": ", !(cin >> number))
        {
            cerr << "Input error, try again. \n";
            if (cin.fail())
            {
                cin.clear();
                cin.ignore();
            }
        }
    }
    return number;
}