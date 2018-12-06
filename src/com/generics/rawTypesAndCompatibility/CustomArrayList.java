package com.generics.rawTypesAndCompatibility;

import java.util.AbstractList;
import java.util.List;

// Can put the cast on the element or when instantiating the array.
// Instantiating array casting is below.
public class CustomArrayList<T> extends AbstractList<T> {

    private T[] values;

    public CustomArrayList() {
        values = (T[]) new Object[0];
    }

    public T get(final int index) {
        return values[index];
    }

    public boolean add(final T o) {
        T[] newValues = (T[]) new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            newValues[i] = values[i];
        }
        newValues[size()] = o;
        values = newValues;
        return true;
    }

    public int size() { return values.length; }

    public static void main(String[] args) {
        List<Integer> arrayList = new CustomArrayList<>();

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
    }
}
