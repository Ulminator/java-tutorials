package com.generics.reflection.classLiterals;

public class Main {

    public static void main(String[] args) {
        Injector injector = new Injector().with("Hello World");

        // Class literals to refer to the Logger class - Used to ensure return type
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
