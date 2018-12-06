package com.generics.classesAndInterfaces;

import com.generics.collections.Person;

import java.util.Comparator;

// Implement a Generic Type
public class AgeComparator implements Comparator<Person> { // implements a generic interface

    @Override
    public int compare(final Person left, final Person right) {
        return Integer.compare(left.getAge(), right.getAge()); // return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
