package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetFirstName_ValidName() {
        String validName = "John";
        this.person.setFirstName(validName);
        assertEquals(validName, this.person.getFirstName());
    }

    @Test
    public void testSetFirstName_EmptyName() {
        String emptyName = "";
        this.person.setFirstName(emptyName);
        assertEquals(emptyName, this.person.getFirstName());
    }
}
