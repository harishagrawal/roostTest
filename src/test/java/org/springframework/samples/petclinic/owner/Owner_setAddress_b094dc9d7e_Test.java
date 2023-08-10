package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_setAddress_b094dc9d7e_Test {

    @InjectMocks
    Person owner;

    @BeforeEach
    void setup() {
        owner = new Person();
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main St";
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }

    @Test
    public void testSetAddress_Null() {
        String address = null;
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }

    @Test
    public void testSetAddress_Empty() {
        String address = "";
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }

    @Test
    public void testSetAddress_LongString() {
        String address = "1234567890123456789012345678901234567890123456789012345678901234567890";
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }
}
