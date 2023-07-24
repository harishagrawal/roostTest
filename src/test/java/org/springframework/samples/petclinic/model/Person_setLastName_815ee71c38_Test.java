package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        this.person = new Person();
    }

    @Test
    public void testSetLastName_Success() {
        String expectedLastName = "Doe";
        this.person.setLastName(expectedLastName);
        assertEquals(expectedLastName, this.person.getLastName());
    }

    @Test
    public void testSetLastName_Null() {
        this.person.setLastName(null);
        assertEquals(null, this.person.getLastName());
    }
}
