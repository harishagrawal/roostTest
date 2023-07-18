package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Owner_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person();
    }

    @Test
    public void testGetAddressWhenAddressIsNull() {
        assertNull(person.getAddress());
    }

    @Test
    public void testGetAddressWhenAddressIsNotNull() {
        String expectedAddress = "123 Main St";
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        assertEquals(expectedAddress, actualAddress);
    }
}
