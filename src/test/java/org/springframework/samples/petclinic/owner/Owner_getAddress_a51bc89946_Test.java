package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

public class Owner_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setAddress("123 Main St");
    }

    @Test
    public void testGetAddress() {
        String expectedAddress = "123 Main St";
        String actualAddress = person.getAddress();
        Assertions.assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testGetAddress_Null() {
        person.setAddress(null);
        Assertions.assertNull(person.getAddress());
    }
}
