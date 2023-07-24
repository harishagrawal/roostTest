package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getFirstName_0d799bf2a4_Test {
    
    @Test
    public void testGetFirstName() {
        // create a new Person object
        Person person = new Person();
        
        // Set the first name of the person
        person.setFirstName("John");
        
        // Assert that the getFirstName method returns the correct value
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testGetFirstNameWithEmptyString() {
        // create a new Person object
        Person person = new Person();
        
        // Set the first name of the person to an empty string
        person.setFirstName("");
        
        // Assert that the getFirstName method returns an empty string
        assertEquals("", person.getFirstName());
    }
}
