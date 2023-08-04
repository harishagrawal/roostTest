package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class Owner2_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String validAddress = "123 Main St";
        person.setAddress(validAddress);
        Assert.isTrue(person.getAddress().equals(validAddress), "Address should be set correctly");
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String emptyAddress = "";
        person.setAddress(emptyAddress);
        Assert.isTrue(person.getAddress().equals(emptyAddress), "Address should be set to empty");
    }

    @Test
    public void testSetAddress_NullAddress() {
        person.setAddress(null);
        Assert.isNull(person.getAddress(), "Address should be set to null");
    }
}
