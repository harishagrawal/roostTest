package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setAddress_5fc57fbb09_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String address = "123 Main St";
        this.person.setAddress(address);
        assertEquals(address, this.person.getAddress());
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String address = "";
        this.person.setAddress(address);
        assertEquals(address, this.person.getAddress());
    }
}
