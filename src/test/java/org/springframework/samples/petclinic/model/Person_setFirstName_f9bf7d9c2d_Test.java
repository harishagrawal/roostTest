package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        person = new Person();
    }

    @Test
    public void testSetFirstName_ValidName() {
        String firstName = "John";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "First name should be set correctly");
    }

    @Test
    public void testSetFirstName_EmptyString() {
        String firstName = "";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "First name should be set correctly even if it's an empty string");
    }
}
