package com.generics.classesAndInterfaces;

import com.generics.collections.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Oldon", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        // Unsorted
        System.out.println(madMen);

        // Sorted
        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);

        // Reverse Sorted
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);


    }
}
