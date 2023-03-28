#ifndef planification_hpp
#define planification_hpp

#include "process.hpp"
#include "list.hpp"

using namespace std;

/*
    It provides us the main planification methods that exist, are
    used static because the class works as tool, not for instances
*/
class Planification
{
    /*
        Compares the property "time" (int) of the Process objec to sort the list
    */
    static bool compareByTime(const Process &p1, const Process &p2)
    {
        return p1.time > p2.time;
    }

    /*
        Compares the property "time" (int) of the Process objec to sort the list
    */
    static bool compareByPriority(const Process &p1, const Process &p2)
    {
        return p1.priority <= p2.priority;
    }


public:

    /*
        Every algorithm consists in deleting the front of the list of proccess
        it simules as a process was processed, every time that a process is 
        processed is necesary to acomulate its time to get the count of its time response
        and every time response is going to acomulate too to make the sum
        to get the time total response.

        Every algorithm return an string because is the way to look how the processes are going
        to be processed.

        Evry algorithm uses a simple Queue methods as insert and remove as FIFO
    */
    static string fifo(List<Process> processes)
    {
        int size = processes.getSize();
 

        string planification = "";

        Process aux = processes.getAt(0);
        int timeResponseTotal = 0;
        int totalTime = 0;

        while (!processes.isEmpty())
        {
            timeResponseTotal += aux.getTimeResponse();
            totalTime += timeResponseTotal;
            aux.setTimeResponse(timeResponseTotal);
            planification += processes.toString();
            planification += " Tr";
            planification += to_string(aux.getId());
            planification += " = ";
            planification += to_string(aux.getTimeResponse());
            planification += "\n";
            processes.remove();
            // When the last one was remove, there isn't way to get the next process
            if (!processes.isEmpty())
            {
                aux = processes.getAt(0);
            }
        }
        planification += "Time prom = ";
        planification += to_string((double)((double)totalTime / (double)size));
        planification += "\n";
        return planification;
    }

    static string sjf(List<Process> processes)
    {
        processes.sortBy(compareByTime);
        int size = processes.getSize();

        string planification = "";

        Process aux = processes.getAt(0);
        int timeResponseTotal = 0;
        int totalTime = 0;

        while (!processes.isEmpty())
        {
            timeResponseTotal += aux.getTimeResponse();
            totalTime += timeResponseTotal;
            aux.setTimeResponse(timeResponseTotal);
            planification += processes.toString();
            planification += " Tr";
            planification += to_string(aux.getId());
            planification += " = ";
            planification += to_string(aux.getTimeResponse());
            planification += "\n";
            processes.remove();
            if (!processes.isEmpty())
            {
                aux = processes.getAt(0);
            }
        }
        planification += "Time prom = ";
        planification += to_string((double)((double)totalTime / (double)size));
        planification += "\n";
        return planification;
    }

    static string priority(List<Process> processes)
    {
        processes.sortBy(compareByPriority); //First it has to be sort by priority, that is 
                                             // the algorithm say us 

        int totalTime = 0;
        int size = processes.getSize();

        //get quantum
        for (int i = 0; i < processes.getSize(); i++)
        {
            totalTime += processes.getAt(i).getTime();
        }
        int quantum = totalTime / processes.getSize();

        int timeResponseTotal = 0;
        Process aux = processes.getAt(0);
        string planification = "";

        while (!processes.isEmpty())
        {
            if (aux.getTime() <= quantum)
            {
                timeResponseTotal += aux.getTimeResponse();
                totalTime += timeResponseTotal;
                aux.setTimeResponse(timeResponseTotal);
                planification += processes.toString();
                planification += " Tr";
                planification += to_string(aux.getId());
                planification += " = ";
                planification += to_string(aux.getTimeResponse());
                planification += "\n";
                processes.remove();
                if (!processes.isEmpty())
                {
                    aux = processes.getAt(0);
                }
            }else{ //If the quantum is lower that the process's time that is going to be processed
                   // it has to be proceesed only with the quantum time, and it hast to change position with its before process
                   // and the process's priority is going to reduce it
                planification += processes.toString();
                planification += " ";
                planification += to_string(quantum);
                planification += "\n";
                aux.time = aux.getTime() - quantum;
                aux.setTimeResponse(aux.time);
                aux.priority = (aux.priority - 1);
                processes.replaceAt(0,aux);
                processes.sortBy(compareByPriority);
                timeResponseTotal += quantum;
                aux = processes.getAt(0);
            }
        }

        planification += "Time prom = ";
        planification += to_string((double)(((double)totalTime-((double)quantum*(double)size)) / (double)size));
        planification += "\n";

        return planification;
    }

    static string roundRobin(List<Process> processes)
    {
        int totalTime = 0;
        int size = processes.getSize();

        for (int i = 0; i < processes.getSize(); i++)
        {
            totalTime += processes.getAt(i).getTime();
        }
        int quantum = totalTime / processes.getSize();

        int timeResponseTotal = 0;
        Process aux = processes.getAt(0);
        string planification = "";

        while (!processes.isEmpty())
        {
            if (aux.getTime() <= quantum)
            {
                timeResponseTotal += aux.getTimeResponse();
                totalTime += timeResponseTotal;
                aux.setTimeResponse(timeResponseTotal);
                planification += processes.toString();
                planification += " Tr";
                planification += to_string(aux.getId());
                planification += " = ";
                planification += to_string(aux.getTimeResponse());
                planification += "\n";
                processes.remove();
                if (!processes.isEmpty())
                {
                    aux = processes.getAt(0);
                }
            }else{ //If the quantum is lower that the process's time that is going to be processed
                   // it has to be proceesed only with the quantum time, and it hast to change position with its before process
                planification += processes.toString();
                planification += " ";
                planification += to_string(quantum);
                planification += "\n";
                aux.time = aux.getTime() - quantum;
                aux.setTimeResponse(aux.time);
                processes.replaceAt(0,processes.getAt(1));
                processes.replaceAt(1,aux);
                timeResponseTotal += quantum;
                aux = processes.getAt(0);
            }
        }

        planification += "Time prom = ";
        planification += to_string((double)(((double)totalTime-((double)size*(double)quantum)) / (double)size));
        planification += "\n";

        return planification;
    }
};

#endif