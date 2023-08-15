package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner2_getTelephone_a676fabad4_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephone_Success() {
        String expectedTelephone = "1234567890";
        String actualTelephone = person.getTelephone();
        Assert.isTrue(expectedTelephone.equals(actualTelephone), "Telephone numbers should be same");
    }

    @Test
    public void testGetTelephone_Failure() {
        String unexpectedTelephone = "0987654321";
        String actualTelephone = person.getTelephone();
        Assert.isTrue(!unexpectedTelephone.equals(actualTelephone), "Telephone numbers should not be same");
    }
}
