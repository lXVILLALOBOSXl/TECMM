#ifndef list_hpp
#define list_hpp

#include <assert.h>
#include <string>
#include "node.hpp"

using namespace std;

template <typename T>
class List
{

    Node<T> *rear;  
    Node<T> *front; 

    int size;

public:
    List();
    ~List();

    int getSize() const { return this->s; }
    bool isEmpty() const { return this->s == 0; };

    bool insert(Node<T> datum);
    bool remove();
    Node<T> getFront();
    Node<T> getRear();

    string toString();
};

#endif