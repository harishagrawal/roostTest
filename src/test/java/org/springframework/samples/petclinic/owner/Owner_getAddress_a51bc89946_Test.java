package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_getAddress_a51bc89946_Test {

    @Test
    public void testGetAddress() {
        // Create a new person object
        Person person = new Person();
        person.setAddress("123 Main St");

        // Test that the getAddress method returns the correct address
        Assert.isTrue(person.getAddress().equals("123 Main St"), "Address does not match expected value");
    }

    @Test
    public void testGetAddressWithNoAddressSet() {
        // Create a new person object without setting an address
        Person person = new Person();

        // Test that the getAddress method returns null when no address is set
        Assert.isNull(person.getAddress(), "Address should be null when not set");
    }
}
