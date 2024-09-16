package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetLastName_Success() {
        String expectedLastName = "Doe";
        person.setLastName(expectedLastName);
        assertEquals(expectedLastName, person.getLastName(), "The last name does not match the expected value");
    }

    @Test
    public void testSetLastName_Null() {
        String expectedLastName = null;
        person.setLastName(expectedLastName);
        assertEquals(expectedLastName, person.getLastName(), "The last name does not match the expected value (null)");
    }
}
