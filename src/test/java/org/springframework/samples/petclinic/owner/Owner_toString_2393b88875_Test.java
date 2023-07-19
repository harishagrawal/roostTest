package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("123 Main St");
        owner.setCity("Springfield");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = "ToStringCreator {id=1, new=false, lastName='Doe', firstName='John', address='123 Main St', city='Springfield', telephone='1234567890'}";
        assertEquals(expected, owner.toString());
    }

    @Test
    public void testToStringWithNullValues() {
        Owner nullOwner = new Owner();
        nullOwner.setId(2);
        String expected = "ToStringCreator {id=2, new=false, lastName=null, firstName=null, address=null, city=null, telephone=null}";
        assertEquals(expected, nullOwner.toString());
    }
}
