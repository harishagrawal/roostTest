package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_getAddress_a51bc89946_Test {

    @Test
    public void testGetAddressSuccess() {
        Person person = new Person();
        person.setAddress("123 Main St");
        Assert.isTrue(person.getAddress().equals("123 Main St"), "Address should be '123 Main St'");
    }

    @Test
    public void testGetAddressNull() {
        Person person = new Person();
        Assert.isNull(person.getAddress(), "Address should be null");
    }

}
