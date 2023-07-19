package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getFirstName_0d799bf2a4_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetFirstName_whenFirstNameIsSet() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);

        String actualFirstName = person.getFirstName();

        assertEquals(expectedFirstName, actualFirstName, "Expected first name does not match actual first name");
    }

    @Test
    public void testGetFirstName_whenFirstNameIsNotSet() {
        String expectedFirstName = null;

        String actualFirstName = person.getFirstName();

        assertEquals(expectedFirstName, actualFirstName, "Expected first name does not match actual first name");
    }
}
