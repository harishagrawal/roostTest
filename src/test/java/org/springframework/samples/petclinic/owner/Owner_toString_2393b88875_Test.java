package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.util.Assert;

public class Owner_toString_2393b88875_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("123 Main St");
        owner.setCity("New York");
        owner.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = "Owner [id=1, new=false, lastName='Doe', firstName='John', address='123 Main St', city='New York', telephone='1234567890']";
        String actual = owner.toString();

        Assert.isTrue(expected.equals(actual), "Owner toString method failed");
    }

    @Test
    public void testToStringWithNullFields() {
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);

        String expected = "Owner [id=1, new=false, lastName='Doe', firstName='John', address=null, city=null, telephone=null]";
        String actual = owner.toString();

        Assert.isTrue(expected.equals(actual), "Owner toString method failed with null fields");
    }
}
