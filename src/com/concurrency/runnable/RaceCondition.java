package com.concurrency.runnable;

import com.concurrency.runnable.model.LongWrapper;

public class RaceCondition {

//    public static void main(String[] args) throws InterruptedException {
//
//        LongWrapper longWrapper = new LongWrapper(0L);
//
//        Runnable r = () -> {
//
//            for (int i = 0; i < 1_000; i++) {
//                longWrapper.incrementValue();
//            }
//        };
//
//        Thread t = new Thread(r);
//        t.start();
//
//        // Makes sure code after the join method is executed after the runnable.
//        t.join();
//
//        System.out.println("Value = " + longWrapper.getValue());
//    }

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable r = () -> {

            for (int i = 0; i < 1_000; i++) {
                longWrapper.incrementValue();
            }
        };

        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        // Not guaranteed to be 1_000_000 due to read and writes in incrementValue method
        // Needs to be synchronized block present
        System.out.println("Value = " + longWrapper.getValue());
    }
}
