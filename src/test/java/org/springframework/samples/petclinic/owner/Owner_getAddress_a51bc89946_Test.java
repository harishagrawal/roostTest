package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getAddress_a51bc89946_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testGetAddress_whenAddressIsSet() {
        String expectedAddress = "123 Main Street";
        owner.setAddress(expectedAddress);
        String actualAddress = owner.getAddress();
        assertEquals(expectedAddress, actualAddress, "Address should be equal to the set value");
    }

    @Test
    public void testGetAddress_whenAddressIsNotSet() {
        String expectedAddress = null;
        String actualAddress = owner.getAddress();
        assertEquals(expectedAddress, actualAddress, "Address should be null when not set");
    }
}
