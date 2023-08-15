package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Person_getLastName_4814a2dee7_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetLastName_Success() {
        String expectedLastName = "Doe";
        this.person.setLastName(expectedLastName);
        String actualLastName = this.person.getLastName();
        Assertions.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetLastName_Null() {
        this.person.setLastName(null);
        String actualLastName = this.person.getLastName();
        Assertions.assertNull(actualLastName);
    }
}
