package com.generics.collections;

import java.util.*;

public class Shuffle {

    public static <E> void swap(List<E> a, int i, int j) {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static void shuffle(List<?> list, Random rnd) {
        for (int i = list.size(); i > 1; i--)
            swap(list, i - 1, rnd.nextInt(i));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (String a : args)
            list.add(a);
        shuffle(list, new Random());
        System.out.println(list);
    }


}
