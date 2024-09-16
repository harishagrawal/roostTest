package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
    }

    @Test
    public void testSetLastName() {
        String lastName = "Doe";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }

    @Test
    public void testSetLastName_Empty() {
        String lastName = "";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }

    // TODO: Add more test cases as per requirements
}
