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
    deleteTree(root);
}

void Tree::deleteTree(Node *p)
{
    if (!p)
    {
        return;
    }
    else
    {
        deleteTree(p->getLeft());
        deleteTree(p->getRight());
        delete p;
    }
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

/*Function search(root: pointer to node, x E 0): {false, true}
Precondition: The tree rooted in root is an ordered tree
P: pointer to node

P <- root
While p != NULL and p^.data != x do
    If x < p^.data then p <- p^.left
    Else p <- p^.right
End while
If p != NULL then return true
Else return false*/

bool Tree::find(int _datum)
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
    if (!p)
    {
        return;
    }
    else
    {
        inorder(p->getLeft());
        printf("%i ", p->getDatum());
        inorder(p->getRight());
    }
}

/*
Binary removal algorithm

Procedure supr(r: pointer to node, x E O)
Precondition: The tree rooted in r is an ordered tree

Locate the node with data x
If the node is located then
    {p is pointing to the node to be removed}
    If p is a leaf node then do leaf node relinking
    Else if p is a one-child node then do one-child node relinking
    Else {p is a complete node} do complete node relinking
    End if
    Delete p
End if
*/

bool Tree::remove(int _datum)
{

    Node *p = root;
    Node *q = nullptr;
    bool qleft = false;

    /*Search of the removal point

    p, q: pointers to node
    qleft: {false, true}

    p <- root
    while p != NULL and p^.dara != x do
        q <- p
        if x < p^.data then
            p <- p^.left
            qleft <- true
        else
            p <- p^.right
            qleft <- false
        end if
    end while

    Delete*/

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
            /*
            Leaf nodes

            {if p has no children then it's a leaf node}

            If p^.left = NULL and p^.right = NULL then
                If p = root then root = NULL
                Else if qleft = true then q^.left <- NULL
                Else q^.right <- NULL
                End if
            End if
            */

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
            /*
            One-child nodes

            {if p is not a leaf node but it still has a NULL pointer then p is a one-child node}

            If p^.left = NULL then {right-child node}
                If p = root then root = p^.right
                else if qleft = true then q^.left <- p^.right
                Else q^.right <- p^.right
                End if
            Else if p^.right = NULL then {left-child node}
                If p = root then root <- p^.left
                Else if qleft = true then q^.left <- p^.left
                Else q^.right <- p.^left
                End if
            End if
            */

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
            /*
            Re-linking for complete nodes

            {p is a complete node}

            Lgp: pointer to node

            If P = root then root <- p^.right
            Else if qleft = true then q^.left <- p^.right
            Else q^.right <- p^.right
            End if
            Lgp <- p^.right
            While lgp^.left != NULL do lgp <- lgp^.left
            lgp^.left <- p^.left
            */

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

void Tree::print()
{
    printf("[ ");
    inorder(root);
    printf("]\n");
}