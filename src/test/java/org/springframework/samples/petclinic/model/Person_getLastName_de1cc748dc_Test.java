package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person();
    }

    @Test
    public void testGetLastNameSuccess() {
        String expectedLastName = "Smith";
        person.setLastName(expectedLastName);
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetLastNameFailure() {
        String expectedLastName = "Johnson";
        person.setLastName("Smith");
        String actualLastName = person.getLastName();
        assertNotEquals(expectedLastName, actualLastName);
    }
}
