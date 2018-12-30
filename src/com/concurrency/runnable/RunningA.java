package com.concurrency.runnable;

import com.concurrency.runnable.model.A;

public class RunningA {

    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        Runnable r1 = () -> a.a();
        Runnable r2 = () -> a.b();

        Thread t1 = new Thread(r1);
        t1.start();

//        t1.join();

        Thread t2 = new Thread(r2);
        t2.start();

        // Deadlock in this scenario.
        t1.join();
        t2.join();
    }
}
