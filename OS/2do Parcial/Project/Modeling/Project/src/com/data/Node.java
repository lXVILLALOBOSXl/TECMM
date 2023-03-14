package com.data;

public class Node <E>{
    private E datum;
    private Node next;

    public Node(E datum) {
        this.datum = datum;
        this.next = null;
    }

    public E getDatum() {
        return datum;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "datum=" + datum +
                ", next=" + next +
                '}';
    }
}
