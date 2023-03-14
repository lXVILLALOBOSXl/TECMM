#ifndef node_hpp
#define node_hpp

#include <string>

using namespace std;

template <typename T>
class Node
{

    T datum;
    Node *next;

public:
    Node(T);
    ~Node();

    T getDatum() const { return datum; }
    Node *getNext() const { return next; }
    Node *setNext(Node *p) { return next = p; }
    string toString();
};

#endif
