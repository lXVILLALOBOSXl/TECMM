#ifndef sjf_hpp
#define sjf_hpp

#include "planification.hpp"

class SJF : public Planification<SJF>
{
    friend Planification<SJF>;

protected:
    static string toStringImpl(List<Process> processes){

    };
};

#endif