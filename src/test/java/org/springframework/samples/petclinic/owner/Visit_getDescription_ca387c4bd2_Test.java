package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getAddress_Test {

    @InjectMocks
    Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAddress() {
        String expectedAddress = "Test Address";
        owner.setAddress(expectedAddress);
        String actualAddress = owner.getAddress();
        assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testGetAddressWhenNoAddressIsSet() {
        String actualAddress = owner.getAddress();
        assertEquals(null, actualAddress);
    }
}
