package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetAddressSuccess() {
        String expectedAddress = "123 Main Street";
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        Assert.isTrue(expectedAddress.equals(actualAddress), "Address does not match");
    }

    @Test
    public void testGetAddressFailure() {
        String expectedAddress = "123 Main Street";
        person.setAddress("456 Elm Street");
        String actualAddress = person.getAddress();
        Assert.isTrue(!expectedAddress.equals(actualAddress), "Address matches unexpectedly");
    }

    @Test
    public void testGetAddressNull() {
        person.setAddress(null);
        String actualAddress = person.getAddress();
        Assert.isNull(actualAddress, "Address is not null");
    }
}
