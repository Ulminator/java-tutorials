package com.generics.collections;

import java.util.Arrays;

public class TheArrayProblem {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        Person[] madMen = { donDraper, peggyOlson };

        System.out.println(madMen);

        System.out.println(Arrays.toString(madMen));

        Person bertCooper = new Person("Bert Cooper", 100);

        madMen = add(bertCooper, madMen);

        System.out.println(Arrays.toString(madMen));

    }

    private static Person[] add(Person person, Person[] array) {
        final int length = array.length;
        array = Arrays.copyOf(array, length + 1);
        array[length] = person;
        return array;
    }
}
