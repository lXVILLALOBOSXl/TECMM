/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Binary Trees
FECHA:      22 de mayo del 2023
*/

#include "set.hpp"

Set::Node::Node(int _datum)
{
    datum = _datum;
    left = nullptr;
    right = nullptr;
}

Set::Set(int capacity)
{
    root = nullptr;
    s = 0;
    n = capacity;
}

Set::~Set()
{
    deleteSet(root);
}

void Set::deleteSet(Node *p)
{
    if (!p)
    {
        return;
    }
    else
    {
        deleteSet(p->getLeft());
        deleteSet(p->getRight());
        delete p;
    }
}

void Set::cleanSet(Node *p){

    if (!p)
    {
        root = nullptr;
        s = 0;
        return;
    }
    else
    {
        cleanSet(p->getLeft());
        cleanSet(p->getRight());
        if(p != root){
            delete p;
        }
    }
    
}

void Set::clean(){

    cleanSet(root);

}

void Set::insert(int _datum)
{
    assert(!isFull());

    if (isEmpty())
    {
        root = new Node(_datum);
        s++;
    }
    else
    {
        Node *p = root;
        Node *q = nullptr;

        while (p and p->getDatum() != _datum)
        {
            q = p;
            p = (_datum < p->getDatum()) ? p->getLeft() : p->getRight();
        }

        if (!p)
        {
            if (_datum < q->getDatum())
            {
                q->setLeft(new Node(_datum));
            }
            else
            {
                q->setRight(new Node(_datum));
            }
            s++;
        }
    }
}

bool Set::member(int _datum)
{
    assert(!isEmpty());

    Node *p = root;

    while (p != nullptr and p->getDatum() != _datum)
    {
        if (_datum < p->getDatum())
        {
            p = p->getLeft();
        }
        else
        {
            p = p->getRight();
        }
    }

    if (p != nullptr)
    {
        return true;
    }

    return false;
}

void Set::inOrder(Node *p)
{
    if (!p)
    {
        return;
    }
    else
    {
        inOrder(p->getLeft());
        printf("%i ", p->getDatum());
        inOrder(p->getRight());
    }
}

bool Set::remove(int _datum)
{

    Node *p = root;
    Node *q = nullptr;
    bool qleft = false;

    while (p != nullptr and p->getDatum() != _datum)
    {
        q = p;
        if (_datum < p->getDatum())
        {
            p = p->getLeft();
            qleft = true;
        }
        else
        {
            p = p->getRight();
            qleft = false;
        }
    }

    if (p != nullptr)
    {
        if (p->getLeft() == nullptr and p->getRight() == nullptr)
        {

            if (p == root)
            {
                root = nullptr;
            }
            else if (qleft)
            {
                q->setLeft(nullptr);
            }
            else
            {
                q->setRight(nullptr);
            }
        }
        else if ((p->getLeft() != nullptr and p->getRight() == nullptr) or (p->getLeft() == nullptr and p->getRight() != nullptr))
        {

            if (p->getLeft() == nullptr)
            {
                if (p == root)
                {
                    root = p->getRight();
                }
                else if (qleft == true)
                {
                    q->setLeft(p->getRight());
                }
                else
                {
                    q->setRight(p->getRight());
                }
            }
            else if (p->getRight() == nullptr)
            {
                if (p == root)
                {
                    root = p->getLeft();
                }
                else if (qleft == true)
                {
                    q->setLeft(p->getLeft());
                }
                else
                {
                    q->setRight(p->getLeft());
                }
            }
        }
        else
        {

            if (p == root)
            {
                root = p->getRight();
            }
            else if (qleft == true)
            {
                q->setLeft(p->getRight());
            }
            else
            {
                q->setRight(p->getRight());
            }

            Node *lgp = p->getRight();

            while (lgp->getLeft() != nullptr)
            {
                lgp = lgp->getLeft();
            }

            lgp->setLeft(p->getLeft());
        }

        delete p;
        return true;
    }

    return false;
}

void Set::print()
{
    printf("[ ");
    inOrder(root);
    printf("]\n");
}