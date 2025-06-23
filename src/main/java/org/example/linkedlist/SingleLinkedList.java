package org.example.linkedlist;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T val = current.getValue();
                current = current.getNext();
                return val;
            }
        };
    }

    public boolean isEmpty() {
        return head == null;
    }
}
