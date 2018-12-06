package com.generics.methods;

import com.generics.classesAndInterfaces.AgeComparator;
import com.generics.collections.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        // Without the generic min method, the comparator did not necessarily have to implement Comparator<Person>
        // It could just be Comparator<Integer>. This would lead to a run time error.
        final Person youngestCastMember = min(madMen, new AgeComparator());

        System.out.println(youngestCastMember);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(30);
        integerList.add(10);
        integerList.add(50);

        final Integer smallestInteger = min(integerList, Integer::compare);

        System.out.println(smallestInteger);

    }

    // <T> allows the return type and parameters to know what T actually is
    // T as the return type makes it to where casting is not necessary when the method is called.
    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }
        T lowestElement = values.get(0);

        for (int i = 0; i < values.size(); i++) {
            final T element = values.get(i);

            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }
}
