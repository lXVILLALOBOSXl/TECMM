#ifndef fifo_hpp
#define fifo_hpp

#include "planification.hpp"

class FIFO : public Planification<FIFO>
{
    friend Planification<FIFO>;

protected:
    static string toStringImpl(List<Process> processes){

    };
};

#endif