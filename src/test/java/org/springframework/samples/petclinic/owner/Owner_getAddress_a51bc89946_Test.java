package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetAddressWhenAddressIsSet() {
        String address = "123 Main St";
        this.person.setAddress(address);
        assertEquals(address, this.person.getAddress());
    }

    @Test
    public void testGetAddressWhenAddressIsNotSet() {
        assertNull(this.person.getAddress());
    }
}
