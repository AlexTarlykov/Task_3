package com.company;

public class SinglyLinkedList<T> {
    private Link<T> firstLink;
    private Link<T> lastLink;
    private int size = 0;

    SinglyLinkedList() {
        firstLink = new Link<>(null, null);
    }

    public int size() {
        return size;
    }

    public void addFirst(T element) {
        if (size > 1) {
            firstLink = new Link<>(element, firstLink);
        } else {
            if (size == 1) {
                lastLink = new Link<>(firstLink.value, null);
                firstLink.next = lastLink;
            }
            firstLink.value = element;
        }
        size++;
    }

    public void add(T element) {
        if (size == 0) {
            if (firstLink == null) {
                firstLink = new Link<>(null, null);
            }
            firstLink.value = element;
        } else if (size == 1) {
            lastLink = new Link<>(element, null);
            firstLink.next = lastLink;
        } else {
            lastLink.next = new Link<>(element, null);
            lastLink = lastLink.next;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index >= 0 || index < size) {
            if (index == 0) {
                addFirst(element);
            } else if (index == size - 1) {
                add(element);
            } else {
                Link<T> early = getLink(index - 1);
                Link<T> next = getLink(index);
                early.next = new Link<>(element, next);
                size++;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Link<T> getLink(int index) {
        if (index >= 0 || index < size) {
            Link<T> link = firstLink;
            for (int i = 1; i <= index; i++) {
                link = link.next;
            }
            return link;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T getValue(int index) {
        return getLink(index).value;
    }

    public void remove(int index) {
        if (index >= 0 || index < size) {
            if (index == 0) {
                Link<T> link = firstLink;
                firstLink = firstLink.next;
                link.next = null;
                link.value = null;
            } else if (index == size - 1) {
                Link<T> link = lastLink;
                lastLink = getLink(size - 2);
                lastLink.next = null;
                link.next = null;
                link.value = null;
            } else {
                Link<T> early = getLink(index - 1);
                Link<T> next = getLink(index + 1);
                Link<T> link = getLink(index);
                link.next = null;
                link.value = null;
                early.next = next;
            }
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static SinglyLinkedList<Integer> fibonacciNumbersList(int n) {
        SinglyLinkedList<Integer> fibonacciNumbersList = new SinglyLinkedList<>();
        int firstNumber = 0;
        int secondNumber = 1;
        if (n > 0) {
            fibonacciNumbersList.add(firstNumber);
        }
        if (n > 1) {
            fibonacciNumbersList.add(secondNumber);
        }
        for (int i = 0; i < n - 2; i++) {
            int newNumber = firstNumber + secondNumber;
            fibonacciNumbersList.add(newNumber);
            firstNumber = secondNumber;
            secondNumber = newNumber;
        }
        return fibonacciNumbersList;
    }

    private static class Link<T> {
        T value;
        Link<T> next;

        Link(T value, Link<T> next) {
            this.next = next;
            this.value = value;
        }
    }
}
