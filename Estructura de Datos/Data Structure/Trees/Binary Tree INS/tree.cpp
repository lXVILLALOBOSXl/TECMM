/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Dynamic Stack
FECHA:      21 de febrero del 2023
*/

#include "tree.hpp"

Tree::Node::Node(int _datum)
{
    datum = _datum;
    left = nullptr;
    right = nullptr;
}

Tree::Tree(int capacity)
{
    root = nullptr;
    s = 0;
    n = capacity;
}

Tree::~Tree()
{
}

/*if root = NULL then root <- node(x)
else
    p <- root
    while p != null and p^.data != x do
        q <- p
        if x < p^.data then p <- p^.left
        else  p <- p^.right
    end while
    if p = NULL then
        if x < q^.data then q^.left <- node(x)
        else q^.right <- node(x)
    end if
end if*/

void Tree::insert(int _datum)
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

/*
If root = NULL then return 
else
	inorder(root^.left) {induction by left}
	inorder(root) 
	inorder(root^.lright) {induction by right}
end if
*/

void Tree::inorder(Node *p)
{
    if(!p){
        return;
    }else{
        inorder(p->getLeft());
        printf("%i ", p->getDatum());
        inorder(p->getRight());
    }


}

void Tree::print() {
    printf("[ ");
    inorder(root);
    printf("]\n");
}