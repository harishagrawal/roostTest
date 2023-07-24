package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

@SpringBootTest
public class Owner_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = Mockito.mock(Person.class);
    }

    @Test
    public void testSetAddress_success() {
        String expectedAddress = "123 Main St";
        Mockito.doAnswer(i -> {
            Assert.isTrue(i.getArgument(0).equals(expectedAddress), "Address does not match expected value");
            return null;
        }).when(person).setAddress(Mockito.anyString());

        person.setAddress(expectedAddress);
    }

    @Test
    public void testSetAddress_emptyString() {
        String expectedAddress = "";
        Mockito.doAnswer(i -> {
            Assert.isTrue(i.getArgument(0).equals(expectedAddress), "Address does not match expected value");
            return null;
        }).when(person).setAddress(Mockito.anyString());

        person.setAddress(expectedAddress);
    }

    @Test
    public void testSetAddress_null() {
        String expectedAddress = null;
        Mockito.doAnswer(i -> {
            Assert.isTrue(i.getArgument(0) == null, "Address is not null");
            return null;
        }).when(person).setAddress(Mockito.anyString());

        person.setAddress(expectedAddress);
    }
}
