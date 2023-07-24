package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = Mockito.mock(Person.class);
    }

    @Test
    public void testGetLastNameSuccess() {
        Mockito.when(person.getLastName()).thenReturn("Doe");
        String lastName = person.getLastName();
        assertEquals("Doe", lastName, "Expected last name to be Doe");
    }

    @Test
    public void testGetLastNameFailure() {
        Mockito.when(person.getLastName()).thenReturn(null);
        String lastName = person.getLastName();
        assertEquals(null, lastName, "Expected last name to be null");
    }
}
