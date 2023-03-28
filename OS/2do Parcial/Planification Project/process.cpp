#include "process.hpp"

int Process::count = 1;

Process::Process(int time, int priority){
    id = count++;
    this->time = time;
    this->priority = priority;
    this->timeResponse = time;
}

Process::~Process(){

}

string Process::toString(){
    string toString = "{";
    toString += "id=";
    toString += to_string(id);
    toString += ", time=";
    toString += to_string(time);
    toString += ", priority=";
    toString += to_string(priority);
    toString += "}";
    return toString;
}