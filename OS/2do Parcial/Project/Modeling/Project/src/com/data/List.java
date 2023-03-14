package com.data;

public class List<E> {
    private Node<E> front;
    private Node<E> rear;

    int size;

    public List() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean insert(Node<E> node){
        return true;
    }

    public boolean remove(){
        return true;
    }

    public Node<E> front(){
        return null;
    }

    public Node<E> rear() {
        return rear;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        String list = "";
        list += "[";
        for (Node aux = front; aux != null; aux = aux.getNext())
        {
            list += (" " + aux.getDatum());
        }
        list += "]";
        return list;
    }
}
