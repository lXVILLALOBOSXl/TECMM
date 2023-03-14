#ifndef planification_hpp
#define planification_hpp

#include "process.hpp"
#include "../data/list.hpp"

using namespace std;

template <typename Derived>
class Planification
{
    static string toString(List<Process> processes) { Derived::toStringImpl(processes); }
};

#endif