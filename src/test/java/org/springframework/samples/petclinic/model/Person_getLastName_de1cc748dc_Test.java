package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetLastName_WithValidLastName() {
        person.setLastName("Smith");
        String lastName = person.getLastName();
        assertEquals("Smith", lastName, "Last name should be Smith");
    }

    @Test
    public void testGetLastName_WithEmptyLastName() {
        person.setLastName("");
        String lastName = person.getLastName();
        assertEquals("", lastName, "Last name should be empty");
    }
}
