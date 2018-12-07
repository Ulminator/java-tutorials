package com.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class CovarianceAndContravariance {

    public static void main(String[] args) {

        // Covariant

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);

        // Anything that the list contains can be upcasted to Number.
        // Cannot add to this list as compiler cannot determine what is the actual type of the object in the generic structure.
        List<? extends Number> myNums;
        myNums = list;

        Number number = myNums.get(0);

        System.out.println(number);


        List<? super Number> myNumsSuper = new ArrayList<>();

        myNumsSuper.add(100);
        myNumsSuper.add(3.3);

        System.out.println(myNumsSuper.get(0).getClass());
        System.out.println(myNumsSuper.get(1).getClass());


        // Contravariant
        // Can only add.

        List<? super Number> destiny = new ArrayList<>();
        destiny.add(1);
        destiny.add(3.4);

        // Both in unison

        List<Integer> myInts = new ArrayList<>();
        myInts.add(1);
        myInts.add(2);
        myInts.add(3);
        myInts.add(4);

        List<Double> myDoubles = new ArrayList<>();
        myDoubles.add(3.14);
        myDoubles.add(6.28);

        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        System.out.println(myObjs);

        copy(myDoubles, myObjs);
        System.out.println(myObjs);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for(Number number : source) {
            destiny.add(number);
        }
    }
}
