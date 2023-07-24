package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_toString_2393b88875_Test {

    private Person owner;

    @BeforeEach
    public void setUp() {
        owner = new Person();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Main St");
        owner.setCity("New York");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = "ToStringCreator [value=Person@1 [new=true, lastName='Doe', firstName='John', address='123 Main St', city='New York', telephone='1234567890']]";
        String actual = owner.toString();
        Assert.isTrue(expected.equals(actual), "Owner toString method failed");
    }

    @Test
    public void testToStringWithEmptyFields() {
        owner.setLastName("");
        owner.setFirstName("");
        owner.setAddress("");
        owner.setCity("");
        owner.setTelephone("");
        String expected = "ToStringCreator [value=Person@1 [new=true, lastName='', firstName='', address='', city='', telephone='']]";
        String actual = owner.toString();
        Assert.isTrue(expected.equals(actual), "Owner toString method failed with empty fields");
    }
}
