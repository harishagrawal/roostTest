package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
    }

    @Test
    void testSetLastNameValid() {
        String lastName = "Smith";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }

    @Test
    void testSetLastNameNull() {
        String lastName = null;
        this.person.setLastName(lastName);
        assertNull(this.person.getLastName());
    }

    @Test
    void testSetLastNameEmpty() {
        String lastName = "";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }
}
