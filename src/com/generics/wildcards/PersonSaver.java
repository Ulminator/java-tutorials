package com.generics.wildcards;

import com.generics.collections.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException {
        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    }

    // Covariant
    // Accepts person or anything that is a subclass of person.
    // On a get operation, only safe to get in class or its subclass.
    public void saveAll(final List<? extends Person> persons) throws IOException {
        for (Person person : persons) {
            save(person);
        }
    }

    // Same as above, but less readable. Use T extends Class when defining a class in order to refer to it in your code.
//    public <T extends Person> void saveAll(final List<T> persons) throws IOException {
//        for (Person person : persons) {
//            save(person);
//        }
//    }

}
