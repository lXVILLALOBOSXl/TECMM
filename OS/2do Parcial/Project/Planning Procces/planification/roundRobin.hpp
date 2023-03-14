#ifndef roundRobin_hpp
#define roundRobin_hpp

#include "planification.hpp"

class RoundRobin : public Planification<RoundRobin>
{
    friend Planification<RoundRobin>;

protected:
    static string toStringImpl(List<Process> processes){

    };
};

#endif