package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Person_setLastName_815ee71c38_Test {

    @InjectMocks
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testSetLastName_WithValidLastName() {
        String validLastName = "Smith";
        person.setLastName(validLastName);
        assertEquals(validLastName, person.getLastName(), "The last name should be set correctly.");
    }

    @Test
    public void testSetLastName_WithEmptyString() {
        String emptyLastName = "";
        person.setLastName(emptyLastName);
        assertEquals(emptyLastName, person.getLastName(), "The last name should be set as an empty string.");
    }
}
