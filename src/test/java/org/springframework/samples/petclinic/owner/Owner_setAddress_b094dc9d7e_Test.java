package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setAddress_b094dc9d7e_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetAddressWithValidAddress() {
        String validAddress = "123 Main St";
        owner.setAddress(validAddress);
        assertEquals(validAddress, owner.getAddress());
    }

    @Test
    public void testSetAddressWithNullAddress() {
        String nullAddress = null;
        owner.setAddress(nullAddress);
        assertEquals(nullAddress, owner.getAddress());
    }
}
