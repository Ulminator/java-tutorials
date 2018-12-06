package com.generics.wildcards;

import com.generics.collections.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

// Substitution Principle
public class PersonStorageTest {

    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 68);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @Test
    public void cannotLoadFromEmptyFile() throws Exception
    {
        PersonLoader loader = new PersonLoader(file);

        assertNull(loader.load());
    }

    @Test
    public void savesAndLoadsPerson() throws Exception {

        saver.save(donDraper);
        assertEquals(donDraper, loader.load());

        saver.save(peggyOlson);
        assertEquals(peggyOlson, loader.load());

    }

    @Test
    public void savesAndLoadsArraysOfPeople() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(bertCooper);

        saver.saveAll(persons);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void loadsListsOfPeople() throws Exception {
        saver.save(donDraper);
        saver.save(peggyOlson);

        List<Object> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(donDraper, people.get(0));
        assertEquals(peggyOlson, people.get(1));

    }

    @After
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }

}
