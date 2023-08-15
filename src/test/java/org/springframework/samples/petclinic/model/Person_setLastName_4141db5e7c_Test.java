package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setLastName_4141db5e7c_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        this.person = new Person();
    }

    @Test
    public void testSetLastName_Success() {
        String expectedLastName = "Smith";
        this.person.setLastName(expectedLastName);
        assertEquals(expectedLastName, this.person.getLastName());
    }

    @Test
    public void testSetLastName_Null() {
        String expectedLastName = null;
        this.person.setLastName(null);
        assertEquals(expectedLastName, this.person.getLastName());
    }
}
