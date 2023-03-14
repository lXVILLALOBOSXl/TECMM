#include "node.hpp"

template <typename T>
Node<T>::Node(T datum)
{
    this->datum = datum;
    next = nullptr;
}

template <typename T>
Node<T>::~Node()
{
    delete this;
}

template <typename T>
string Node<T>::toString()
{
    return "Node{" + "datum=" + datum.toString() + ", next=" + next.toString() + "}";
}