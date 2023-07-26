package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String validAddress = "123 Main St, Anytown, Anystate";
        this.person.setAddress(validAddress);
        assertEquals(validAddress, this.person.getAddress());
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String emptyAddress = "";
        this.person.setAddress(emptyAddress);
        assertEquals(emptyAddress, this.person.getAddress());
    }

    @Test
    public void testSetAddress_NullAddress() {
        String nullAddress = null;
        this.person.setAddress(nullAddress);
        assertEquals(nullAddress, this.person.getAddress());
    }

    // TODO: Add more test cases if needed
}
