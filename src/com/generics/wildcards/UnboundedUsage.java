package com.generics.wildcards;

import com.generics.collections.Person;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsage {

    public static void main(String[] args) {
        List<? super Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Person("Don Draper", 89));
        System.out.println(objects);

        List<?> objects2 = new ArrayList<>();
        // null is the only value that can be coerced into any type
        objects2.add(null);
        System.out.println(objects2);

        List<? extends Object> objects3 = new ArrayList<>();
        objects3.add(null);
        System.out.println(objects3);
    }
}
