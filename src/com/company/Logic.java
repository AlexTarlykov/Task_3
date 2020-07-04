package com.company;

import java.util.ArrayDeque;

public class Logic {

    public static void function(ArrayDeque<Integer> deque) {
        ArrayDeque<Integer> evenIndexNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> oddIndexNumbers = new ArrayDeque<>();
        int i = 0;
        while (!deque.isEmpty()) {
            if (i++ % 2 == 0) {
                evenIndexNumbers.add(deque.pollFirst());
            } else {
                oddIndexNumbers.add(deque.pollFirst());
            }
        }
        int j = 0;
        while (!evenIndexNumbers.isEmpty() || !oddIndexNumbers.isEmpty()) {
            if (j++ % 2 == 0 && !oddIndexNumbers.isEmpty()) {
                deque.add(oddIndexNumbers.pollFirst());
            } else if (!evenIndexNumbers.isEmpty()) {
                deque.add(evenIndexNumbers.pollFirst());
            }
        }
    }

    public static void function(MyQueue<Integer> queue) {
        MyQueue<Integer> evenIndexNumbers = new MyQueue<>();
        MyQueue<Integer> oddIndexNumbers = new MyQueue<>();
        int i = 0;
        while (queue.isNotEmpty()) {
            if (i++ % 2 == 0) {
                evenIndexNumbers.add(queue.remove());
            } else {
                oddIndexNumbers.add(queue.remove());
            }
        }
        int j = 0;
        while (evenIndexNumbers.isNotEmpty() || oddIndexNumbers.isNotEmpty()) {
            if (j++ % 2 == 0 && oddIndexNumbers.isNotEmpty()) {
                queue.add(oddIndexNumbers.remove());
            } else if (evenIndexNumbers.isNotEmpty()) {
                queue.add(evenIndexNumbers.remove());
            }
        }
    }
}
