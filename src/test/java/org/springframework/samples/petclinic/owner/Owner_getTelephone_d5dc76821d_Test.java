package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_getTelephone_d5dc76821d_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephone_success() {
        String expectedTelephone = "1234567890";
        String actualTelephone = person.getTelephone();
        Assert.isTrue(expectedTelephone.equals(actualTelephone), "Telephone numbers do not match");
    }

    @Test
    public void testGetTelephone_failure() {
        String expectedTelephone = "0987654321";
        String actualTelephone = person.getTelephone();
        Assert.isTrue(!expectedTelephone.equals(actualTelephone), "Telephone numbers match unexpectedly");
    }
}
