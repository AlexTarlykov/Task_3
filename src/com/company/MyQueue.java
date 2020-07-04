package com.company;

public class MyQueue<T> {
    private final SinglyLinkedList<T> queue = new SinglyLinkedList<>();

    public void add(T element) {
        queue.add(element);
    }

    public T remove() {
        T element = queue.getValue(0);
        queue.remove(0);
        return element;
    }

    public boolean isNotEmpty() {
        return queue.size() != 0;
    }

    public int size() {
        return queue.size();
    }
}
