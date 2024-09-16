package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setLastName("Smith");
    }

    @Test
    public void testGetLastName_success() {
        String expectedLastName = "Smith";
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName, "The last name should match the expected value");
    }

    @Test
    public void testGetLastName_failure() {
        String expectedLastName = "Johnson";
        String actualLastName = person.getLastName();
        assertNotEquals(expectedLastName, actualLastName, "The last name should not match the expected value");
    }
}
