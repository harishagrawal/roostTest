package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetLastName() {
        String lastName = "Doe";
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }

    @Test
    public void testSetLastName_Null() {
        assertThrows(NullPointerException.class, () -> person.setLastName(null));
    }
}
