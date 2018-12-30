package com.concurrency.singleton;

public class BasicSingleton {

    private static BasicSingleton instance;

    // Can only build this class in itself.
    private BasicSingleton() {}

    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}