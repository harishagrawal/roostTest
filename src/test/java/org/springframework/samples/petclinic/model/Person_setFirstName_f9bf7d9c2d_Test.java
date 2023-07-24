package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setFirstName_f9bf7d9c2d_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetFirstName_Success() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void testSetFirstName_Null() {
        String expectedFirstName = null;
        person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, person.getFirstName());
    }
}
