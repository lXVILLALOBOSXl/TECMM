#ifndef list_hpp
#define list_hpp

#include <iostream>
#include <string>

using namespace std;

template <class T>
class List {
private:
    struct Node {
        T data;
        Node* next;
    };
    Node* front;
    Node* rear;
    int size;

public:
    List() {
        front = rear = NULL;
        size = 0;
    }

    ~List() {
        /*while (front != NULL) {
            Node* temp = front;
            front = front->next;
            delete temp;
        }*/
    }

    int getSize() const { return size; }
    bool isEmpty() const { return size == 0; };

    void insert(T datum) {
        Node* temp = new Node;
        temp->data = datum;
        temp->next = NULL;
        if (front == NULL) {
            front = rear = temp;
        }
        else {
            rear->next = temp;
            rear = temp;
        }
        size++;
    }

    void remove() {
        if (front == NULL) {
            cout << "The list is empty." << endl;
            return;
        }
        Node* temp = front;
        front = front->next;
        delete temp;
        size--;
    }

    void replaceAt(int index, T datum) {
        if (index < 0 || index >= size) {
            cout << "Invalid index." << endl;
            return;
        }
        Node* temp = front;
        for (int i = 0; i < index; i++) {
            temp = temp->next;
        }
        temp->data = datum;
    }

    T getAt(int index) {
        if (index < 0 || index >= size) {
            cout << "Invalid index." << endl;
            exit(1);
        }
        Node* temp = front;
        for (int i = 0; i < index; i++) {
            temp = temp->next;
        }
        return temp->data;
    }

    void sortBy(bool(*compare)(const T&, const T&)) {
        if (size <= 1) {
            return;
        }
        for (Node* i = front; i->next != NULL; i = i->next) {
            for (Node* j = i->next; j != NULL; j = j->next) {
                if (compare(i->data, j->data)) {
                    swap(i->data, j->data);
                }
            }
        }
    }

    string toString()
    {
        string list = "[ ";
        Node* aux = front;
        int i = 0;
        while (i < size)
        {
            list += aux->data.toString();
            list += "  ";
            aux = aux->next;
            i++;
        }
        list += "]";

        return list;
    }
};



#endif