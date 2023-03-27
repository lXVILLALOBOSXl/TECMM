#ifndef planification_hpp
#define planification_hpp

#include "process.hpp"
#include "list.hpp"

using namespace std;

class Planification
{
    static bool compareByTime(const Process &p1, const Process &p2)
    {
        return p1.time > p2.time;
    }

    static bool compareByPriority(const Process &p1, const Process &p2)
    {
        return p1.priority <= p2.priority;
    }


public:
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
        processes.sortBy(compareByPriority);
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
            }else{
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
            }else{
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