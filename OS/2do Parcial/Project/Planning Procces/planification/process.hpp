#ifndef process_hpp
#define process_hpp

#include <string>

using namespace std;

class Process
{
    static int count;
    int id;
    int priority;
    int time;

public:
    Process(int, int);
    ~Process();

    int getId() { return id; };
    int getTime() { return time; };
    int getPriority() { return priority; };

    string toString();
};

#endif