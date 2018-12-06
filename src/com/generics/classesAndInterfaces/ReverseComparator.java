package com.generics.classesAndInterfaces;

import java.util.Comparator;

// Pass Up a Type Parameter
public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(T o1, T o2) {
        return -1 * delegateComparator.compare(o1, o2);
    }
}
