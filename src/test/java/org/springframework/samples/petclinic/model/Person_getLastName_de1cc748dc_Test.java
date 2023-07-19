package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Person_getLastName_de1cc748dc_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetLastName_Success() {
        String expectedLastName = "Smith";
        person.setLastName(expectedLastName);
        String actualLastName = person.getLastName();
        Assertions.assertEquals(expectedLastName, actualLastName, "The last name should be Smith");
    }

    @Test
    public void testGetLastName_Null() {
        String expectedLastName = null;
        person.setLastName(expectedLastName);
        String actualLastName = person.getLastName();
        Assertions.assertNull(actualLastName, "The last name should be null");
    }
}
