package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getAddress_4a6790754a_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetAddress() {
        String address = "123 Main St";
        this.person.setAddress(address);
        assertEquals(address, this.person.getAddress());
    }

    @Test
    public void testGetAddress_Empty() {
        String address = "";
        this.person.setAddress(address);
        assertEquals(address, this.person.getAddress());
    }

    @Test
    public void testGetAddress_Null() {
        this.person.setAddress(null);
        assertEquals(null, this.person.getAddress());
    }
}
