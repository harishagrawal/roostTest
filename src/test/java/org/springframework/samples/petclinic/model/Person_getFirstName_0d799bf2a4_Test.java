// Test generated by RoostGPT for test RoostTest using AI Type Open AI and AI Model gpt-4

package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

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
        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void testGetFirstName_whenFirstNameIsNotSet() {
        // TODO: Change the value of defaultFirstName as per your application default value
        String defaultFirstName = null;
        String actualFirstName = person.getFirstName();
        assertEquals(defaultFirstName, actualFirstName);
    }
}
