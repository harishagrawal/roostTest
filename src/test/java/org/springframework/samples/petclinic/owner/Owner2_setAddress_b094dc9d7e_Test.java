package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String validAddress = "123 Main St";
        this.person.setAddress(validAddress);
        Assert.isTrue(this.person.getAddress().equals(validAddress), "Address should be set correctly");
    }

    @Test
    public void testSetAddress_NullAddress() {
        String nullAddress = null;
        this.person.setAddress(nullAddress);
        Assert.isTrue(this.person.getAddress() == null, "Address should be null");
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String emptyAddress = "";
        this.person.setAddress(emptyAddress);
        Assert.isTrue(this.person.getAddress().equals(emptyAddress), "Address should be empty");
    }
}
