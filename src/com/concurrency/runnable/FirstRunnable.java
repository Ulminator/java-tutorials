package com.concurrency.runnable;

public class FirstRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("I am running in " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.setName("my thread");

        thread.start();

//        Will be called in the main thread.
//        thread.run();
    }
}
