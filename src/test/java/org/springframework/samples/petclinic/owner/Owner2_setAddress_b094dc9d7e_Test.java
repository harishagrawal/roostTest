package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.owner.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Owner2_setAddress_b094dc9d7e_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String validAddress = "123 Main St";
        owner.setAddress(validAddress);
        assertEquals(validAddress, owner.getAddress());
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String emptyAddress = "";
        owner.setAddress(emptyAddress);
        assertEquals(emptyAddress, owner.getAddress());
    }
}
