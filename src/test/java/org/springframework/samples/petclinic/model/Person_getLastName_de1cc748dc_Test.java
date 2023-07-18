package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Person_getLastName_de1cc748dc_Test {

    @Mock
    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetLastNameSuccess() {
        String expectedLastName = "Doe";
        when(person.getLastName()).thenReturn(expectedLastName);
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName, "The last name should match the expected value");
    }

    @Test
    public void testGetLastNameFailure() {
        String expectedLastName = "Smith";
        when(person.getLastName()).thenReturn("Doe");
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName, "The last name should match the expected value");
    }
}
