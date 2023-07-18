package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Owner_setAddress_b094dc9d7e_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main Street";
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }

    @Test
    public void testSetAddressWithNull() {
        assertThrows(NullPointerException.class, () -> owner.setAddress(null));
    }
}
