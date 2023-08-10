package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setLastName("Smith");
    }

    @Test
    public void testGetLastName() {
        String expected = "Smith";
        String actual = person.getLastName();
        assertEquals(expected, actual, "Failed to get the correct last name");
    }

    @Test
    public void testGetLastName_Null() {
        person.setLastName(null);
        String actual = person.getLastName();
        assertEquals(null, actual, "Failed to handle null last name");
    }

}
