package com.concurrency.runnable.model;

public class LongWrapper {

    private final Object key = new Object();
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }
}
