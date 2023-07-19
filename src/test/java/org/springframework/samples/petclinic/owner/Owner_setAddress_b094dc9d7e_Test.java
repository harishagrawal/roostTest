package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.util.Assert;

public class Owner_setAddress_b094dc9d7e_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main St";
        owner.setAddress(address);
        Assert.isTrue(owner.getAddress().equals(address), "Address should be set correctly");
    }

    @Test
    public void testSetAddress_Null() {
        String address = null;
        owner.setAddress(address);
        Assert.isTrue(owner.getAddress() == null, "Address should be null");
    }

    @Test
    public void testSetAddress_Empty() {
        String address = "";
        owner.setAddress(address);
        Assert.isTrue(owner.getAddress().equals(address), "Address should be empty");
    }

    @Test
    public void testSetAddress_WhiteSpace() {
        String address = " ";
        owner.setAddress(address);
        Assert.isTrue(owner.getAddress().equals(address), "Address should be a white space");
    }
}
