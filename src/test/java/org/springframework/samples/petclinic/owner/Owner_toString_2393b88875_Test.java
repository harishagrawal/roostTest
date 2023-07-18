package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Owner_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Main St");
        owner.setCity("Springfield");
        owner.setTelephone("1234567890");
    }

    @Test
    void testToString() {
        String expected = "ToStringCreator [value=Owner@1c3a4799[id = 1, new = true, lastName = 'Doe', firstName = 'John', address = '123 Main St', city = 'Springfield', telephone = '1234567890']]";
        assertEquals(expected, owner.toString());
    }

    @Test
    void testToStringWithNullValues() {
        owner = new Owner();
        String expected = "ToStringCreator [value=Owner@1c3a4799[id = 0, new = false, lastName = 'null', firstName = 'null', address = 'null', city = 'null', telephone = 'null']]";
        assertEquals(expected, owner.toString());
    }
}
