package com.generics.collections;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age){
        this.name = Objects.requireNonNull(name, "Name must not be null");
        this.age = age;
    }

    public int getAge() { return age; }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Person) {
//            Person person = (Person) obj;
//            return age == person.age && name.equals(person.name);
//        }
//        return false;
//    }

    @Override
    public int hashCode(){
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
