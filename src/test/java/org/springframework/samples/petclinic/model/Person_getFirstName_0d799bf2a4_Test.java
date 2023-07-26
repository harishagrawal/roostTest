package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getFirstName_0d799bf2a4_Test {

    @InjectMocks
    Person person;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        person = new Person();
    }

    @Test
    public void testGetFirstName() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);
        String actualFirstName = person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void testGetFirstName_Null() {
        person.setFirstName(null);
        String actualFirstName = person.getFirstName();
        assertEquals(null, actualFirstName);
    }

}
