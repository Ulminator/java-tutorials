package com.generics.rawTypesAndCompatibility;

import java.util.List;

public class Erasure<T, B extends Comparable<B>> {

    public void unbounded(T param) {

    }

    public void lists(List<String> param, List<List<T>> param2) {
        String s = param.get(0);
    }

    public void bounded(B param) {

    }
}

// javac src/com/generics/rawTypesAndCompatibility/Erasure.java
// javap -s -classpath src/ com.generics.rawTypesAndCompatibility.Erasure
// javap -s -c -classpath src/ com.generics.rawTypesAndCompatibility.Erasure
// Decompile the bytecode that's been produced by javac.