#ifndef priority_hpp
#define priority_hpp

#include "planification.hpp"

class Priority : public Planification<Priority>
{
    friend Planification<Priority>;

protected:
    static string toStringImpl(List<Process> processes){
        return "";
    };
};

#endif