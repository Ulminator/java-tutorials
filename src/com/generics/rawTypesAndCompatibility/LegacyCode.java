package com.generics.rawTypesAndCompatibility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {

    public static void main(String[] args) {
        // This is a Raw Type (allows interoperability and compatibility with legacy libraries)
        List list = new ArrayList();
        list.add("abc");
        list.add(1);
        list.add(new Object());

        // Can still work! Will throw a ClassCastException if iterating over them.
        List<String> strings = list;

//        When to use Iterator?
//        - Remove the current element. For-each hides the iterator, so you cannot call remove.
//        - Iterate over multiple collections in parallel.
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            final Object element = iterator.next();
            System.out.println(element);
        }
    }
}
