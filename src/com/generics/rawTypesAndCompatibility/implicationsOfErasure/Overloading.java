package com.generics.rawTypesAndCompatibility.implicationsOfErasure;

import java.util.List;

public class Overloading {

    public void print(String param) {

    }

    public void print(Integer param) {

    }

    // List of String and List of Integer become just List<Object> at runtime.

    public void print(List<String> param) {

    }

//    public void print(List<Integer> param) {
//
//    }
}
