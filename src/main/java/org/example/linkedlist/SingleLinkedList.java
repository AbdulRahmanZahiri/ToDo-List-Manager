package org.example.linkedlist;

import java.util.Iterator;

/**
 * A simple implementation of a generic singly linked list.
 * Supports adding elements and iteration.
 *
 * @param <T> the type of elements stored in the list
 */
public class SingleLinkedList<T> implements Iterable<T> {
    private Node<T> head; // The head (first node) of the list

    /**
     * Adds a new element to the end of the linked list.
     *
     * @param value the value to be added
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            // If the list is empty, set new node as head
            head = newNode;
        } else {
            // Traverse to the last node and add the new node
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /**
     * Returns the head node of the list.
     *
     * @return head node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns true if the list is empty.
     *
     * @return true if no elements, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Allows the list to be used in a for-each loop.
     *
     * @return an iterator over the list elements
     */
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
}
