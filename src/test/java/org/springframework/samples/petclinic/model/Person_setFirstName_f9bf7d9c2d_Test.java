package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetFirstName() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);

        assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void testSetFirstName_emptyString() {
        String expectedFirstName = "";
        person.setFirstName(expectedFirstName);

        assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void testSetFirstName_null() {
        String expectedFirstName = null;
        person.setFirstName(expectedFirstName);

        assertEquals(expectedFirstName, person.getFirstName());
    }
}
