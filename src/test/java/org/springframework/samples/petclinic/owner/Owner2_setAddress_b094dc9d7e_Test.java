package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Owner2_setAddress_b094dc9d7e_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetAddress_success() {
        String expectedAddress = "123 Main St";
        person.setAddress(expectedAddress);
        assertEquals(expectedAddress, person.getAddress());
    }

    @Test
    public void testSetAddress_failure() {
        String expectedAddress = "123 Main St";
        person.setAddress("456 Oak St");
        assertNotEquals(expectedAddress, person.getAddress());
    }
}
