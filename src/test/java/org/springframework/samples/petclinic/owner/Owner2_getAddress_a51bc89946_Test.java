package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetAddress() {
        String expectedAddress = "123 Main St";
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        assertEquals(expectedAddress, actualAddress, "Address should be 123 Main St");
    }

    @Test
    public void testGetAddress_Empty() {
        String expectedAddress = "";
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        assertEquals(expectedAddress, actualAddress, "Address should be empty");
    }

    @Test
    public void testGetAddress_Null() {
        person.setAddress(null);
        String actualAddress = person.getAddress();
        assertEquals(null, actualAddress, "Address should be null");
    }
}
