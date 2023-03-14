#include "process.hpp"

int Process::count = 1;

Process::Process(int time, int priority){
    id = count++;
    this->time = time;
    this->priority = priority;
}

Process::~Process(){
    delete this;
}

string Process::toString(){
    string toString = "Process{";
    toString += "id=";
    toString += id;
    toString += ", time=";
    toString += time;
    toString += ", priority=";
    toString += priority;
    toString += "}";
    return toString;
}