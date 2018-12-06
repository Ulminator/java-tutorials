package com.generics.rawTypesAndCompatibility.implicationsOfErasure;

public class InstanceOfExample<T> {

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof InstanceOfExample<T>) {
        if (obj instanceof InstanceOfExample) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceOfExample<>() instanceof InstanceOfExample);
        System.out.println(new InstanceOfExample<>() instanceof Object);
    }
}
