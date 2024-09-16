package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class Owner_setAddress_b094dc9d7e_Test {

    private Person owner;

    @BeforeEach
    void setUp() {
        this.owner = new Person();
    }

    @Test
    void testSetAddressValid() {
        String validAddress = "123 Main Street";
        this.owner.setAddress(validAddress);
        assertEquals(validAddress, this.owner.getAddress());
    }

    @Test
    void testSetAddressNull() {
        String nullAddress = null;
        this.owner.setAddress(nullAddress);
        assertNull(this.owner.getAddress());
    }

    @Test
    void testSetAddressEmpty() {
        String emptyAddress = "";
        this.owner.setAddress(emptyAddress);
        assertEquals(emptyAddress, this.owner.getAddress());
    }

    @Test
    void testSetAddressWithSpaces() {
        String addressWithSpaces = " 123 Main Street ";
        this.owner.setAddress(addressWithSpaces);
        assertEquals(addressWithSpaces.trim(), this.owner.getAddress());
    }
}
