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
    public void testGetLastName_whenLastNameIsSet() {
        String expectedLastName = "Doe";
        person.setLastName(expectedLastName);
        
        String actualLastName = person.getLastName();
        
        assertEquals(expectedLastName, actualLastName, "Expected and actual last names do not match.");
    }

    @Test
    public void testGetLastName_whenLastNameIsNotSet() {
        String expectedLastName = null;
        
        String actualLastName = person.getLastName();
        
        assertEquals(expectedLastName, actualLastName, "Expected null but found a value for last name.");
    }
}
