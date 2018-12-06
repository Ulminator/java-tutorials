package com.generics.reflection.classLiterals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Injector {

    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    public Injector with(Object value) {
        objectGraph.put(value.getClass(), value);
        return this;
    }

    public <T> T newInstance(final Class<T> type) {
        return (T) objectGraph.computeIfAbsent(type, this::instantiate);
    }

    // objectGraph has an entry of type String and value is "Hello World"
    // This method finds the classes necessary for the Logger constructor and injects those values into it.
    private Object instantiate(Class<?> type) {
        try {
            Constructor<?>[] constructors = type.getConstructors();
            if (constructors.length !=1) {
                throw new IllegalArgumentException(type + " must only have 1 constructor.");
            }
            Constructor<?> constructor = constructors[0];
            Object[] args = Stream.of(constructor.getParameterTypes())
                    .map(param -> (Object) newInstance(param))
                    .toArray();
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
