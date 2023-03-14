#include "list.hpp"

template <typename T>
List<T>::List()
{
    front = nullptr;
    rear = nullptr;
    size = 0;
}

template <typename T>
List<T>::~List()
{
    delete;
}

template <typename T>
bool List<T>::insert(Node<T> datum)
{
    return false;
}

template <typename T>
bool List<T>::remove()
{
    return false;
}

template <typename T>
Node<T> List<T>::getFront()
{
    return nullptr;
}

template <typename T>
Node<T> List<T>::getRear()
{
    return nullptr;
}

template <typename T>
string List<T>::toString(){
    return "";
}