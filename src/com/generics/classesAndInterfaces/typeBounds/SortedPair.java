package com.generics.classesAndInterfaces.typeBounds;

// Type Bounds
public class SortedPair<T extends Comparable<T>> {

    private final T first;
    private final T second;

    // Anything passed into left or right must implement the comparable interface
    public SortedPair(T left, T right) {
        if (left.compareTo(right) < 0) {
            first = left;
            second = right;
        } else {
            first = right;
            second = left;
        }

    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public String toString() {
        return "SortedPair{\"first\"=" + first + ", \"second\"=" + second + "}";
    }

}
