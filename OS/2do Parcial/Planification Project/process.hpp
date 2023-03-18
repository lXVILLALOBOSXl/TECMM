#ifndef process_hpp
#define process_hpp

#include <string>

using namespace std;

class Process
{
    static int count;
    int id;
    int timeResponse;

public:

    Process(){};
    Process(int, int);
    ~Process();

    int priority;
    int time;

    int getId() { return id; };
    int getTime() { return time; };
    int getPriority() { return priority; };
    int getTimeResponse() { return timeResponse; };

    void setTimeResponse(int time) { timeResponse = time; };
    string toString();
};

#endif