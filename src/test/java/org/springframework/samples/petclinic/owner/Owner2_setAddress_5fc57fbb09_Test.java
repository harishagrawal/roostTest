package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_setAddress_5fc57fbb09_Test {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testSetAddress_normalCase() {
        String address = "123 Main St";
        person.setAddress(address);
        assertEquals(address, person.getAddress());
    }

    @Test
    public void testSetAddress_emptyString() {
        String address = "";
        person.setAddress(address);
        assertEquals(address, person.getAddress());
    }

    @Test
    public void testSetAddress_nullValue() {
        String address = null;
        person.setAddress(address);
        assertEquals(address, person.getAddress());
    }
}
